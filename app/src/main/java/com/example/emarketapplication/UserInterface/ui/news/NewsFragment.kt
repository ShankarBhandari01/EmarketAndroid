package com.example.emarketapplication.UserInterface.ui.news

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.emarketapplication.R
import com.example.emarketapplication.adapter.MyAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class NewsFragment : Fragment() {
    lateinit var tab_layout: TabLayout
    lateinit var view_pager_2: ViewPager2
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_news, container, false)
        tab_layout = view.findViewById(R.id.tab_layout)
        view_pager_2 = view.findViewById(R.id.view_pager_2)
        val adapter = activity?.let { MyAdapter(it.supportFragmentManager, lifecycle) }
        view_pager_2.adapter = adapter
        TabLayoutMediator(tab_layout,view_pager_2) { tab, position ->
            when(position){
                0->{
                    tab.text="Orders"
                }
                1->{
                    tab.text="Offers"
                }
            }
        }.attach()
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()

    }
}