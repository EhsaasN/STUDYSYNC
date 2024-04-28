package com.example.studysync

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.database.IgnoreExtraProperties
import com.google.firebase.database.database
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.auth.User
import com.google.firebase.firestore.firestore
import java.util.Objects


class Register : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        val email=findViewById<EditText>(R.id.username)
        val password=findViewById<EditText>(R.id.password)
        val create=findViewById<Button>(R.id.create)
        val btn=findViewById<TextView>(R.id.BACK)
        val fname=findViewById<EditText>(R.id.fname)
        val ph=findViewById<EditText>(R.id.pnumber)
        val auth=FirebaseAuth.getInstance()
        val fstore= Firebase.firestore

        //val auth =Firebase.auth

        create.setOnClickListener(){
            val em=email.text.toString()
            val pw=password.text.toString()
            val fullname=fname.text.toString()
            val phonenumber=ph.text.toString()
            if(email == null||password==null){
                Toast.makeText(this@Register,"USERNAME OR PASSWORD CANNOT BE EMPTY",
                    Toast.LENGTH_LONG).show()
            }
            auth.createUserWithEmailAndPassword(em, pw)
                .addOnCompleteListener() { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        val userid= auth.currentUser!!.uid.toString()
                       //val documentReference=fstore.collection("user profiles").document(userid)
                       /* val user= hashMapOf(
                            "fullname" to name,
                            "email" to email,
                            "phonenumber" to phonenumber,
                            "password" to password,
                        )
                        //documentReference.set(user)
                        fstore.collection("user profiles").add(user)*/
                       /* documentReference.addOnCompleteListener(){
                            Toast.makeText(
                                this@Register,
                                "USER REGISTERED",
                                Toast.LENGTH_SHORT,
                            ).show()
                        }*/

                        val user1 = auth.currentUser
                        Toast.makeText(
                            this@Register,
                            "USER REGISTERED",
                            Toast.LENGTH_SHORT,
                        ).show()


                    } else {
                        // If sign in fails, display a message to the user.

                        Toast.makeText(
                            this@Register,
                            "Authentication failed.",
                            Toast.LENGTH_SHORT,
                        ).show()

                    }
                }

        }
        btn.setOnClickListener(){
            val intent =Intent(this,Login::class.java).also {
                startActivity(it)
                finish()
            }
        }

    }
}