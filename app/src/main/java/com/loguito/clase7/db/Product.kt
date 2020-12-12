package com.loguito.clase7.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

// TODO 1: Crear entidad (tablas en la base de datos)
@Entity
data class Product (
    @PrimaryKey val id: String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "quantity") val quantity: Int
)