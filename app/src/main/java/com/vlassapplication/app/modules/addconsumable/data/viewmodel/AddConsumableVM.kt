package com.vlassapplication.app.modules.addconsumable.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vlassapplication.app.entities.Consumable
import com.vlassapplication.app.modules.addconsumable.`data`.model.AddConsumableModel
import org.koin.core.KoinComponent

class AddConsumableVM : ViewModel(), KoinComponent {
    private val _consumablesList: MutableLiveData<List<Consumable>> = MutableLiveData()
    val consumablesList get() = _consumablesList

    fun updateList(updatedList: List<Consumable>) {
        _consumablesList.value = updatedList
    }

    val addConsumableModel: MutableLiveData<AddConsumableModel> =
      MutableLiveData(AddConsumableModel())

  var navArguments: Bundle? = null
}
