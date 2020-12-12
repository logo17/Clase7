package com.loguito.clase7.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

// TODO 3: Creamos la base de datos de room (exponemos los diferentes DAO e inicializamos SINGLETON la base de datos)
@Database(entities = arrayOf(Product::class), version = 1, exportSchema = false)
public abstract class ProductDatabase : RoomDatabase() {
    abstract fun productDao() : ProductDAO

    companion object {
        @Volatile
        private var INSTANCE: ProductDatabase? = null

        fun getDatabase(context: Context) : ProductDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ProductDatabase::class.java,
                    "product_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}