package com.vlassapplication.app.modules.menuconsumables.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vlassapplication.app.modules.menuconsumables.`data`.model.ListtwoRowModel
import com.vlassapplication.app.modules.menuconsumables.`data`.model.MenuConsumablesModel
import kotlin.collections.MutableList
import org.koin.core.KoinComponent

class MenuConsumablesVM : ViewModel(), KoinComponent {
    private val _listtwoList = MutableLiveData<MutableList<ListtwoRowModel>>()
    val listtwoList: LiveData<MutableList<ListtwoRowModel>> get() = _listtwoList

    fun updateList(newList: MutableList<ListtwoRowModel>) {
        _listtwoList.value = newList
    }

    val menuConsumablesModel: MutableLiveData<MenuConsumablesModel> =
      MutableLiveData(MenuConsumablesModel())

  var navArguments: Bundle? = null

    fun setCurrentKmageText(km:String){
        menuConsumablesModel.value?.currentKmageText = km
    }



/*  val listtwoList: MutableLiveData<MutableList<ListtwoRowModel>> = MutableLiveData(mutableListOf())*/
}
