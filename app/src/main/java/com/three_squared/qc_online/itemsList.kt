package com.three_squared.qc_online

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.*
import androidx.lifecycle.Observer
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

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

        val addToBasketDialog = AddToBasketDialogFragment()

        val recyclerView : RecyclerView = view.findViewById(R.id.itemsRecyclerView)

        recyclerView.setHasFixedSize(true)

        val alert = AlertDialog.Builder(this.context).setMessage("Item added").create()
        val adapter = itemsListRecyclerViewAdapter(mutableListOf()) { item ->
            mainViewModel.basket.add(item)
            addToBasketDialog.show(
                childFragmentManager, AddToBasketDialogFragment.TAG)
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


        val basketButton : FloatingActionButton = view.findViewById(R.id.basketButton)

        basketButton.setOnClickListener {
            findNavController().navigate(R.id.basket, null)
        }

            return view
    }
}

class AddToBasketDialogFragment : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            val inflater = requireActivity().layoutInflater

            builder.setView(inflater.inflate(R.layout.add_to_basket_dialog, null))
                .setPositiveButton("yes",
                    DialogInterface.OnClickListener { dialog, id ->

                    })
                .setNegativeButton("Cancel",
                    DialogInterface.OnClickListener { dialog, id ->
                        dialog.dismiss()
                    })
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }

    companion object {
        const val TAG = "AddToBasketDialog"
    }
}
