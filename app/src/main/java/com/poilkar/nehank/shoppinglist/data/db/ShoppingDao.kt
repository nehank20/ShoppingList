package com.poilkar.nehank.shoppinglist.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.poilkar.nehank.shoppinglist.data.db.entity.ShoppingItem

@Dao
interface ShoppingDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(item : ShoppingItem)

    @Delete
    suspend fun delete(item : ShoppingItem)

    @Query("SELECT * FROM shopping_table")
    fun getAllShoppingItems() : LiveData<List<ShoppingItem>>


}