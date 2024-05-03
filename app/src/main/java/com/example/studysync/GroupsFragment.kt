package com.example.studysync

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [GroupsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class GroupsFragment : Fragment() {
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
        val v=inflater.inflate(R.layout.fragment_groups, container, false)
        val m= v.findViewById<Button>(R.id.mathematics)
        val physics=v.findViewById<Button>(R.id.physics)
        val bee=v.findViewById<Button>(R.id.bee)
        val chem=v.findViewById<Button>(R.id.chem)
        val cs=v.findViewById<Button>(R.id.communicationskills)
        val pps=v.findViewById<Button>(R.id.pps)
        val intent= Intent(Intent.ACTION_VIEW,Uri.parse("https://chat.whatsapp.com/GsGSOVaAI4J5xCOdiv0duU"))
        m?.setOnClickListener {
            startActivity(intent)
        }
        physics.setOnClickListener{

            startActivity(intent)
        }
        bee.setOnClickListener{

            startActivity(intent)
        }
        chem.setOnClickListener{

            startActivity(intent)
        }
        cs.setOnClickListener{

            startActivity(intent)
        }
        pps.setOnClickListener{

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
         * @return A new instance of fragment GroupsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            GroupsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}