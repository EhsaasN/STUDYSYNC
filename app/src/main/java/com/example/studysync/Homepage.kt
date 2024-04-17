package com.example.studysync

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import com.example.studysync.databinding.ActivityHomepageBinding
import java.lang.Exception

import com.google.android.material.bottomnavigation.BottomNavigationMenuView
import com.google.android.material.bottomnavigation.BottomNavigationView

//lateinit var bottomnav : BottomNavigationView
//lateinit var binding :ActivityHomepageBinding
class Homepage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // bottomnav=findViewById(R.id.bottomNavigationView2)
        var binding= ActivityHomepageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(HomeFragment())
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