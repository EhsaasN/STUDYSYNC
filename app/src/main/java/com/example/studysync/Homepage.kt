package com.example.studysync

import android.app.DownloadManager
import android.content.Context
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.studysync.databinding.ActivityHomepageBinding
import java.lang.Exception

import com.google.android.material.bottomnavigation.BottomNavigationMenuView
import com.google.android.material.bottomnavigation.BottomNavigationView

//lateinit var bottomnav : BottomNavigationView
//lateinit var binding :ActivityHomepageBinding
class Notes
    ( var image : Int
      , var subj_name : String
      ,var url : String?
)
class NotesAdapter( var data: ArrayList<Notes>, var context: Context) : RecyclerView.Adapter<NotesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layout = LayoutInflater.from(context).inflate(R.layout.item_layoutfile, parent, false)
        return ViewHolder(layout)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = data[position].subj_name
        holder.image.setImageResource(data[position].image)
        holder.itemView.setOnClickListener{
            var download= context.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
            var PdfUri = Uri.parse(data[position].url)
            var getPdf = DownloadManager.Request(PdfUri)
            getPdf.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
            download.enqueue(getPdf)
            Toast.makeText(context,"Download Started", Toast.LENGTH_LONG).show()
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal val name: TextView
        internal val image: ImageView
        init {
            name = itemView.findViewById(R.id.subj_name)
            image = itemView.findViewById(R.id.pdf_image)
        }
    }
}

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
        val item = ArrayList<Notes>()
        item.add(
            Notes(
                R.drawable.pdf,
                "M1",
                "https://firebasestorage.googleapis.com/v0/b/studysync-f2afe.appspot.com/o/M1%20whole%20pdf.pdf?alt=media&token=d17bcf4f-9b39-4681-a919-6a9201e24c37"
            )
        )
        item.add(
            Notes(
                R.drawable.pdf,
                "DBMS",
                "https://firebasestorage.googleapis.com/v0/b/online-learning-ea8c0.appspot.com/o/Uploads%2Fdbms_tutorial%20(1).pdf?alt=media&token=7e8a8500-5c94-4b03-a088-3b071d8b35e1"
            )
        )
        item.add(
            Notes(
                R.drawable.pdf,
                "C Notes",
                "https://firebasestorage.googleapis.com/v0/b/online-learning-ea8c0.appspot.com/o/Uploads%2F%5BStudycrux.com%5D%20Let%20us%20C%20by%20Yashwant%20Kanetkar%20(1).pdf?alt=media&token=671c6f65-26f1-4524-ac23-66e321aa5db1"
            )
        )
        item.add(
            Notes(
                R.drawable.pdf,
                "Resume",
                "https://firebasestorage.googleapis.com/v0/b/online-learning-ea8c0.appspot.com/o/Uploads%2F%5BStudycrux.com%5D%20Let%20us%20C%20by%20Yashwant%20Kanetkar%20(1).pdf?alt=media&token=671c6f65-26f1-4524-ac23-66e321aa5db1"
            )
        )
        val recycler_view  = findViewById<RecyclerView>(R.id.recycler_view)
        recycler_view.layoutManager = LinearLayoutManager(applicationContext)
        val adapter = NotesAdapter(item,this)
        recycler_view.adapter = adapter

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