package com.three_squared.qc_online

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Basket : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_basket, container, false)

        val mainViewModel = (activity as MainActivity).mainActivityViewModel

        val recyclerView : RecyclerView = view.findViewById(R.id.basketRecyclerView)

        recyclerView.setHasFixedSize(true)

        val adapter = BaskRecyclerViewAdapter(mainViewModel.basket) { item ->

        }

        recyclerView.adapter = adapter

        recyclerView.layoutManager = LinearLayoutManager(this.context)

        return view
    }
}