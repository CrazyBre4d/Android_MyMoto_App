package com.vlassapplication.app.modules.menumain.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vlassapplication.app.modules.menumain.`data`.model.MenuMainModel
import org.koin.core.KoinComponent

class MenuMainVM : ViewModel(), KoinComponent {
  val menuMainModel: MutableLiveData<MenuMainModel> = MutableLiveData(MenuMainModel())

  var navArguments: Bundle? = null

  fun setCurrentKmageText(km:String){
    menuMainModel.value?.txt21500 = km
  }
}
