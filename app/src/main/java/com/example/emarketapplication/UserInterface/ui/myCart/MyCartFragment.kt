package com.example.emarketapplication.UserInterface.ui.myCart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.emarketapplication.R


class MyCartFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_mycart, container, false)
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()

    }
}