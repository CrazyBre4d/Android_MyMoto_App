package com.vlassapplication.app.modules.updatekmage.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vlassapplication.app.entities.Consumable
import com.vlassapplication.app.entities.Kmage
import com.vlassapplication.app.modules.updatekmage.`data`.model.UpdateKmageModel
import org.koin.core.KoinComponent

class UpdateKmageVM : ViewModel(), KoinComponent {
    private val _kmage: MutableLiveData<Kmage> = MutableLiveData()
    val consumablesList get() = _kmage

    fun updateKmage(kmage: Kmage) {
        _kmage.value = kmage
    }

    val updateKmageModel: MutableLiveData<UpdateKmageModel> = MutableLiveData(UpdateKmageModel())

  var navArguments: Bundle? = null
}
