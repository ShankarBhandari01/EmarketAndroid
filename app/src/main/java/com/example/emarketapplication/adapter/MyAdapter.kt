package com.example.emarketapplication.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.emarketapplication.UserInterface.OffersFragment
import com.example.emarketapplication.UserInterface.Orders

@Suppress("DEPRECATION")
class MyAdapter(
    fm: FragmentManager,
    lifecycle: Lifecycle
) : FragmentStateAdapter(fm,lifecycle) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
     return when(position){
           0->{
               Orders()
           }
           1->{
               OffersFragment()
           }
         else -> {
             Fragment()
         }
     }
}

}