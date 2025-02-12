package com.poilkar.nehank.shoppinglist.ui

import android.content.Context
import android.os.Bundle
import android.view.Window
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.poilkar.nehank.shoppinglist.R
import com.poilkar.nehank.shoppinglist.data.db.entity.ShoppingItem
import kotlinx.android.synthetic.main.alert_add_shopping_item.*

class AddShoppingItemDialog(context: Context, var dialogListener : AddDialogListener) : AppCompatDialog(context){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.alert_add_shopping_item)


        tvAdd.setOnClickListener {
            val name = etName.text.toString()
            val amount = etAmount.text.toString().toInt()
            if(name.isNullOrEmpty()) {
                Toast.makeText(context, "Please enter a name", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val item = ShoppingItem(name, amount)
            dialogListener.onAddButtonClicked(item)
            dismiss()
        }

        tvCancel.setOnClickListener {
            cancel()
        }
    }
}