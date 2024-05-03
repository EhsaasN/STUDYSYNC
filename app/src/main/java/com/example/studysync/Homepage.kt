package com.example.studysync



import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.util.Log
import android.widget.Button

import android.widget.TextView
import androidx.core.content.ContentProviderCompat.requireContext

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.studysync.databinding.ActivityHomepageBinding



class Homepage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // bottomnav=findViewById(R.id.bottomNavigationView2)
        var binding= ActivityHomepageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(HomeFragment())
        val maths=findViewById<Button>(R.id.mathematics)


        //maths.movementMethod=LinkMovementMethod.getInstance()
       /*
        maths.setOnClickListener{
            intent= Intent(Intent.ACTION_VIEW,Uri.parse("https://chat.whatsapp.com/GsGSOVaAI4J5xCOdiv0duU"))
            startActivity(intent)
        }
        */
        /*m.setOnClickListener(){
            intent= Intent(Intent.ACTION_VIEW, Uri.parse("https://firebasestorage.googleapis.com/v0/b/studysync-f2afe.appspot.com/o/M1%20whole%20pdf.pdf?alt=media&token=d17bcf4f-9b39-4681-a919-6a9201e24c37"))
            startActivity(intent)
        }
        */

    binding.bottomNavigationView2.setOnItemSelectedListener {
            when(it.itemId){
                R.id.home ->{replaceFragment(HomeFragment())
                true}
                R.id.pdf ->{replaceFragment(pdfFragment())
                true}
                R.id.profile ->{replaceFragment(ProfileFragment())
                true}
                R.id.groups ->{replaceFragment(GroupsFragment())
                    val groups=GroupsFragment()
                    val gp: FragmentManager=supportFragmentManager
                    gp.beginTransaction().add(R.id.grouplayout,groups).commit()
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