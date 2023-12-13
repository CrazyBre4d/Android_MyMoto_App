package com.vlassapplication.app.modules.menumain.`data`.model

import com.vlassapplication.app.R
import com.vlassapplication.app.appcomponents.di.MyApp
import kotlin.String

data class MenuMainModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtSix: String? = MyApp.getInstance().resources.getString(R.string.lbl11)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtYamahaVirago: String? = MyApp.getInstance().resources.getString(R.string.lbl_yamaha_virago)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtXv1100Counter: String? = MyApp.getInstance().resources.getString(R.string.lbl_xv1100_1986)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txt10633: String? = MyApp.getInstance().resources.getString(R.string.lbl_1063_3)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtSeven: String? = MyApp.getInstance().resources.getString(R.string.lbl13)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txt21500: String? = MyApp.getInstance().resources.getString(R.string.lbl_21_500)

)
