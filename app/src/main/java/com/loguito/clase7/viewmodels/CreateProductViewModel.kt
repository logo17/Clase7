package com.loguito.clase7.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.loguito.clase7.db.Product
import com.loguito.clase7.db.ProductDatabase
import com.loguito.clase7.repository.ProductRepository
import kotlinx.coroutines.launch

// TODO 6: Creamos el viewmodel encargado de llamar al metodo para insertar productos a la base de datos. Este llamado tiene que hacerse en una coroutine
class CreateProductViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: ProductRepository
    private val database: ProductDatabase = ProductDatabase.getDatabase(application)

    init {
        repository = ProductRepository(database.productDao())
    }

    fun insertProduct(product: Product) {
        // TODO 7 : Recordar agregar las extensiones del VIEWMODEL
        viewModelScope.launch {
            repository.insert(product)
        }
    }
}