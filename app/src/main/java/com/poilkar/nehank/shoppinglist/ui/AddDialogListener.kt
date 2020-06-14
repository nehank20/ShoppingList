package com.poilkar.nehank.shoppinglist.ui

import com.poilkar.nehank.shoppinglist.data.db.entity.ShoppingItem

interface AddDialogListener {

    fun onAddButtonClicked(item: ShoppingItem)
}

