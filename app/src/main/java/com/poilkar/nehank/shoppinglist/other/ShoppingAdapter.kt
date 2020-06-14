package com.poilkar.nehank.shoppinglist.other

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.poilkar.nehank.shoppinglist.R
import com.poilkar.nehank.shoppinglist.data.db.entity.ShoppingItem
import com.poilkar.nehank.shoppinglist.ui.ShoppingViewModel
import kotlinx.android.synthetic.main.row_shopping_item.view.*

class ShoppingAdapter(
    var items: List<ShoppingItem>,
    private val viewmodel: ShoppingViewModel
) : RecyclerView.Adapter<ShoppingAdapter.ShoppingViewHolder>(){

    inner class ShoppingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_shopping_item,parent,false)
        return ShoppingViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {
        val currentShoppingItem = items[position]
        holder.itemView.tvName.text = currentShoppingItem.name
        holder.itemView.tvQty.text = currentShoppingItem.quantity.toString()

        holder.itemView.ivDelete.setOnClickListener {
            viewmodel.delete(currentShoppingItem)
        }

        holder.itemView.ivAdd.setOnClickListener {
            currentShoppingItem.quantity++
            viewmodel.upsert(currentShoppingItem)
        }

        holder.itemView.ivRemove.setOnClickListener {
            if(currentShoppingItem.quantity > 0){
                currentShoppingItem.quantity --
                viewmodel.upsert(currentShoppingItem)
            }
        }
    }
}