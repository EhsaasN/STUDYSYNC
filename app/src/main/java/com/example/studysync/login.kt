package com.example.studysync

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.firestore


class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.loginfinal)
        val username = findViewById<EditText>(R.id.username)
        val password = findViewById<EditText>(R.id.password)
        val create = findViewById<TextView>(R.id.createprofile)
        val signin = findViewById<Button>(R.id.signin)
        val auth = FirebaseAuth.getInstance()
        val log=findViewById<TextView>(R.id.login)
        val fstore= Firebase.firestore
        log.setOnClickListener(){
            intent= Intent(Intent.ACTION_VIEW, Uri.parse("https://chat.whatsapp.com/GsGSOVaAI4J5xCOdiv0duU"))
            startActivity(intent)
        }

        signin.setOnClickListener() {
            val user = username.text.toString()
            val pass = password.text.toString()
            if (user == null || pass == null) {
                Toast.makeText(
                    this@Login, "USERNAME OR PASSWORD CANNOT BE EMPTY",
                    Toast.LENGTH_LONG
                ).show()
            }
            auth.signInWithEmailAndPassword(user, pass)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information

                        val user = auth.currentUser

                        Toast.makeText(this@Login,"LOGIN SUCCESSFUL",Toast.LENGTH_LONG).show()
                        val intent=Intent(this,Homepage::class.java).also {
                            startActivity(it)
                            finish()
                        }
                    } else {
                        // If sign in fails, display a message to the user.

                        Toast.makeText(
                            this@Login,
                            "Authentication failed.",
                            Toast.LENGTH_SHORT,
                        ).show()

                    }
                }

        }
        create.setOnClickListener(){
            val intent = Intent(this,Register::class.java).also {
                startActivity(it)
                finish()
            }
    }
}
}


