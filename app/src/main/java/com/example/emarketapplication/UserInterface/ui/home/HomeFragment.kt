package com.example.emarketapplication.UserInterface.ui.home

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import com.example.emarketapplication.R


class HomeFragment : Fragment() {
    lateinit var ImgbtnCart: ImageButton
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        ImgbtnCart = view.findViewById(R.id.ImgbtnCart)
        ImgbtnCart.setOnClickListener {
            val builder = AlertDialog.Builder(context)
            builder.setTitle("Cart")
            builder.setMessage("Item added to cart !!")

            builder.setPositiveButton(android.R.string.yes) { dialog, which ->

            }
            builder.setNeutralButton("Cancel") { dialog, which ->

            }
            builder.show()
        }


        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()

    }
}