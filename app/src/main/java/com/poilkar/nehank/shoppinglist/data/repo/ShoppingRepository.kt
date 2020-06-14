package com.poilkar.nehank.shoppinglist.data.repo

import com.poilkar.nehank.shoppinglist.data.db.ShoppingDatabase
import com.poilkar.nehank.shoppinglist.data.db.entity.ShoppingItem

class ShoppingRepository(
    private val db: ShoppingDatabase
) {
    suspend fun upsert(item: ShoppingItem) = db.getShoppingDao().upsert(item)

    suspend fun delete(item: ShoppingItem) = db.getShoppingDao().delete(item)


    fun getAllShoppingItems() = db.getShoppingDao().getAllShoppingItems()
}