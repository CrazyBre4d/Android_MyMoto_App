package com.vlassapplication.app.modules.updatekmage.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vlassapplication.app.modules.updatekmage.`data`.model.UpdateKmageModel
import org.koin.core.KoinComponent

class UpdateKmageVM : ViewModel(), KoinComponent {
    /*fun updateList(updatedList: Unit) {
        _consumablesList.value = updatedList
    }*/

    val updateKmageModel: MutableLiveData<UpdateKmageModel> = MutableLiveData(UpdateKmageModel())

  var navArguments: Bundle? = null
}
