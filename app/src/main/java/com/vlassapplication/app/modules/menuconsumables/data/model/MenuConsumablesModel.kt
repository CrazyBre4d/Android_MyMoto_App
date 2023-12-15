package com.vlassapplication.app.modules.menuconsumables.`data`.model

import com.vlassapplication.app.R
import com.vlassapplication.app.appcomponents.di.MyApp
import kotlin.String

data class MenuConsumablesModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtFour: String? = MyApp.getInstance().resources.getString(R.string.lbl8)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var currentKmageText: String = "21500"
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtLanguage: String? = MyApp.getInstance().resources.getString(R.string.lbl9)

)
