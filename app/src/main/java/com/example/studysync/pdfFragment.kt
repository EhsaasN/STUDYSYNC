package com.example.studysync

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [pdfFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class pdfFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v=inflater.inflate(R.layout.fragment_pdf, container, false)
        val m=v.findViewById<TextView>(R.id.M1)
        val p=v.findViewById<TextView>(R.id.phy)
        val b=v.findViewById<TextView>(R.id.beeee)
        val ch=v.findViewById<TextView>(R.id.chemistry)
        val c=v.findViewById<TextView>(R.id.cs)
        val px=v.findViewById<TextView>(R.id.PPS)
        m.setOnClickListener(){
           val intent= Intent(Intent.ACTION_VIEW, Uri.parse("https://firebasestorage.googleapis.com/v0/b/studysync-f2afe.appspot.com/o/M1%20whole%20pdf.pdf?alt=media&token=d17bcf4f-9b39-4681-a919-6a9201e24c37"))
            startActivity(intent)
        }
        p.setOnClickListener(){
            val intent=Intent(Intent.ACTION_VIEW, Uri.parse("https://firebasestorage.googleapis.com/v0/b/studysync-f2afe.appspot.com/o/physics.pdf?alt=media&token=7113c492-7f63-466c-a745-1398cc75e8ef"))
            startActivity(intent)
        }
        b.setOnClickListener(){
            val intent=Intent(Intent.ACTION_VIEW, Uri.parse("https://firebasestorage.googleapis.com/v0/b/studysync-f2afe.appspot.com/o/BEE%20PDF.pdf?alt=media&token=14b11bf1-ce6c-4d67-9562-70c0c8da6f5a"))
            startActivity(intent)
        }
        ch.setOnClickListener(){
            val intent=Intent(Intent.ACTION_VIEW, Uri.parse("https://firebasestorage.googleapis.com/v0/b/studysync-f2afe.appspot.com/o/chem%20whole%20pdf.pdf?alt=media&token=22bed6b7-b21d-4133-a161-74edea1dc97a"))
            startActivity(intent)
        }
        c.setOnClickListener(){
            val intent=Intent(Intent.ACTION_VIEW, Uri.parse("https://firebasestorage.googleapis.com/v0/b/studysync-f2afe.appspot.com/o/email.%20writing.docx?alt=media&token=efd0840c-8f13-4580-bd8e-d93a34502c79"))
            startActivity(intent)
        }
        px.setOnClickListener(){
            val intent=Intent(Intent.ACTION_VIEW, Uri.parse("https://firebasestorage.googleapis.com/v0/b/studysync-f2afe.appspot.com/o/pps.pdf?alt=media&token=ead3c679-144b-49ec-88e5-bb011f9117de"))
            startActivity(intent)
        }
        return v
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment pdfFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            pdfFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}