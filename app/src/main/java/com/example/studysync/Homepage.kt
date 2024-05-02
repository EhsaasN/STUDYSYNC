package com.example.studysync



import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.studysync.databinding.ActivityHomepageBinding

//lateinit var bottomnav : BottomNavigationView
//lateinit var binding :ActivityHomepageBinding

class Homepage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // bottomnav=findViewById(R.id.bottomNavigationView2)
        var binding= ActivityHomepageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(HomeFragment())
        val maths=findViewById<Button>(R.id.mathematics)
        val physics=findViewById<Button>(R.id.physics)
        val bee=findViewById<Button>(R.id.bee)
        val chem=findViewById<Button>(R.id.chem)
        val cs=findViewById<Button>(R.id.communicationskills)
        val pps=findViewById<Button>(R.id.pps)
        val m=findViewById<TextView>(R.id.M1)
        val p=findViewById<TextView>(R.id.phy)
        val b=findViewById<TextView>(R.id.beeee)
        val ch=findViewById<TextView>(R.id.chemistry)
        val c=findViewById<TextView>(R.id.cs)
        val Px=findViewById<TextView>(R.id.PPS)
        maths.setOnClickListener(){
            intent=Intent(Intent.ACTION_VIEW, Uri.parse("https://chat.whatsapp.com/GsGSOVaAI4J5xCOdiv0duU"))
            startActivity(intent)
        }
        physics.setOnClickListener(){
            intent=Intent(Intent.ACTION_VIEW, Uri.parse("https://chat.whatsapp.com/GsGSOVaAI4J5xCOdiv0duU"))
            startActivity(intent)
        }
        bee.setOnClickListener(){
            intent=Intent(Intent.ACTION_VIEW, Uri.parse("https://chat.whatsapp.com/GsGSOVaAI4J5xCOdiv0duU"))
            startActivity(intent)
        }
        chem.setOnClickListener(){
            intent=Intent(Intent.ACTION_VIEW, Uri.parse("https://chat.whatsapp.com/GsGSOVaAI4J5xCOdiv0duU"))
            startActivity(intent)
        }
        cs.setOnClickListener(){
            intent=Intent(Intent.ACTION_VIEW, Uri.parse("https://chat.whatsapp.com/GsGSOVaAI4J5xCOdiv0duU"))
            startActivity(intent)
        }
        pps.setOnClickListener(){
            intent=Intent(Intent.ACTION_VIEW, Uri.parse("https://chat.whatsapp.com/GsGSOVaAI4J5xCOdiv0duU"))
            startActivity(intent)
        }
        /*m.setOnClickListener(){
            intent= Intent(Intent.ACTION_VIEW, Uri.parse("https://firebasestorage.googleapis.com/v0/b/studysync-f2afe.appspot.com/o/M1%20whole%20pdf.pdf?alt=media&token=d17bcf4f-9b39-4681-a919-6a9201e24c37"))
            startActivity(intent)
        }
        p.setOnClickListener(){
            intent=Intent(Intent.ACTION_VIEW, Uri.parse("https://google.com"))
            startActivity(intent)
        }
        b.setOnClickListener(){
            intent=Intent(Intent.ACTION_VIEW, Uri.parse("https://firebasestorage.googleapis.com/v0/b/studysync-f2afe.appspot.com/o/BEE%20PDF.pdf?alt=media&token=14b11bf1-ce6c-4d67-9562-70c0c8da6f5a"))
            startActivity(intent)
        }
        ch.setOnClickListener(){
            intent=Intent(Intent.ACTION_VIEW, Uri.parse("https://firebasestorage.googleapis.com/v0/b/studysync-f2afe.appspot.com/o/chem%20whole%20pdf.pdf?alt=media&token=22bed6b7-b21d-4133-a161-74edea1dc97a"))
            startActivity(intent)
        }
        c.setOnClickListener(){
            intent=Intent(Intent.ACTION_VIEW, Uri.parse("https://google.com"))
            startActivity(intent)
        }
        P.setOnClickListener(){
            intent=Intent(Intent.ACTION_VIEW, Uri.parse("https://google.com"))
            startActivity(intent)
        }*/

    binding.bottomNavigationView2.setOnItemSelectedListener {
            when(it.itemId){
                R.id.home ->{replaceFragment(HomeFragment())
                true}
                R.id.pdf ->{replaceFragment(pdfFragment())
                true}
                R.id.profile ->{replaceFragment(ProfileFragment())
                true}
                R.id.groups ->{replaceFragment(GroupsFragment())
                true}
                else ->{replaceFragment(HomeFragment())
                true}
            }
            return@setOnItemSelectedListener true
        }
    }
    private fun replaceFragment(fragment: Fragment){
        val transaction=supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame_layout,fragment)
        transaction.commit()
    }
}