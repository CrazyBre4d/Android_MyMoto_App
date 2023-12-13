package com.vlassapplication.app.modules.menusettings.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vlassapplication.app.modules.menusettings.`data`.model.MenuSettingsModel
import org.koin.core.KoinComponent

class MenuSettingsVM : ViewModel(), KoinComponent {
  val menuSettingsModel: MutableLiveData<MenuSettingsModel> = MutableLiveData(MenuSettingsModel())

  var navArguments: Bundle? = null
}
