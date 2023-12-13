package com.vlassapplication.app.modules.changemoto.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vlassapplication.app.modules.changemoto.`data`.model.ChangeMotoModel
import org.koin.core.KoinComponent

class ChangeMotoVM : ViewModel(), KoinComponent {
  val changeMotoModel: MutableLiveData<ChangeMotoModel> = MutableLiveData(ChangeMotoModel())

  var navArguments: Bundle? = null
}
