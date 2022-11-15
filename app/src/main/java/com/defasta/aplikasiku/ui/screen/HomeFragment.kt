package com.defasta.aplikasiku.ui.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.defasta.aplikasiku.R


class HomeFragment : Fragment() {
    private lateinit var tvHeloFragment: TextView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tvHeloFragment.findViewById<TextView>(R.id.tvHeloFragment)
        tvHeloFragment.text = "Halo gais"

    }

}