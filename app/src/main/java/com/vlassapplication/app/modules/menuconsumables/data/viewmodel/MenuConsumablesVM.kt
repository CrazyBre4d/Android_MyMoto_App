package com.vlassapplication.app.modules.menuconsumables.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vlassapplication.app.modules.menuconsumables.`data`.model.ListtwoRowModel
import com.vlassapplication.app.modules.menuconsumables.`data`.model.MenuConsumablesModel
import kotlin.collections.MutableList
import org.koin.core.KoinComponent

class MenuConsumablesVM : ViewModel(), KoinComponent {
  val menuConsumablesModel: MutableLiveData<MenuConsumablesModel> =
      MutableLiveData(MenuConsumablesModel())

  var navArguments: Bundle? = null

  val listtwoList: MutableLiveData<MutableList<ListtwoRowModel>> = MutableLiveData(mutableListOf())
}
