package com.poilkar.nehank.shoppinglist.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shopping_table")
data class ShoppingItem(
    @ColumnInfo(name = "shopping_item")
    var name :String,
    @ColumnInfo(name = "shopping_qty")
    var quantity : Int
) {
    @PrimaryKey(autoGenerate = true)
    var id : Int? = null
}