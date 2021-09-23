package com.example.emarketapplication.UserInterface.ui.more

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment
import com.example.emarketapplication.R
import com.example.emarketapplication.UserInterface.MapsActivity


class MoreFragment : Fragment() {
    lateinit var listView: ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_more, container, false)
        listView = view.findViewById(R.id.listView)
        val name = arrayOf("Profile", "Report", "Setting", "Map", "Register your fam", "feedback")

        val adapter = context?.let {
            ArrayAdapter(
                it,
                android.R.layout.simple_list_item_1, name
            )
        }

        listView.adapter = adapter
        listView.setOnItemClickListener { adapterView, view, i, l ->
            val position = i
            if (position == 3) {
                startActivity(Intent(context, MapsActivity::class.java))
            }
        }
        return view
    }


}