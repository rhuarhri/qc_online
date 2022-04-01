package com.three_squared.qc_online

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * A simple [Fragment] subclass.
 * Use the [itemsList.newInstance] factory method to
 * create an instance of this fragment.
 */
class itemsList : Fragment() {

    val itemListViewModel : itemListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_items_list, container, false)

        val mainViewModel = (activity as MainActivity).mainActivityViewModel

        val recyclerView : RecyclerView = view.findViewById(R.id.itemsRecyclerView)

        recyclerView.setHasFixedSize(true)

        val adapter = itemsListRecyclerViewAdapter(mutableListOf()) { item ->

        }

        recyclerView.adapter = adapter

        recyclerView.layoutManager = LinearLayoutManager(this.context)


        val observer = Observer<List<Item>> {
            if (!it.isNullOrEmpty()) {
                recyclerView.post {
                    adapter.setData(it as MutableList<Item>)
                }
            }
        }

        itemListViewModel.menu.observe(viewLifecycleOwner, observer)

        itemListViewModel.getMenu()

            return view
    }
}