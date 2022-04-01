package com.three_squared.qc_online

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class itemsListRecyclerViewAdapter(private var items : MutableList<Item>, private val itemClicked : (item: Item) -> Unit) : RecyclerView.Adapter<itemsListRecyclerViewAdapter.ItemViewHolder>() {

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemNameTXT : TextView = itemView.findViewById(R.id.itemName)
        val addItemButton : ImageButton = itemView.findViewById(R.id.addItemButton)
        val priceTXT : TextView = itemView.findViewById(R.id.priceTXT)
        val descriptionTXT : TextView = itemView.findViewById(R.id.itemDescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = items[position]
        holder.itemNameTXT.text = item.name
        holder.priceTXT.text = item.price.toString()
        holder.descriptionTXT.text = item.description
        val onClick = {
            itemClicked.invoke(item)
        }

        holder.addItemButton.setOnClickListener {
            onClick.invoke()
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun setData(items: MutableList<Item>) {
        this.items = items
        notifyDataSetChanged()
    }
}