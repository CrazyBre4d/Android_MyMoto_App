package com.vlassapplication.app.modules.menuconsumables.`data`.model

import com.vlassapplication.app.R
import com.vlassapplication.app.appcomponents.di.MyApp
import kotlin.String

data class ListtwoRowModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtTwo: String? = MyApp.getInstance().resources.getString(R.string.lbl10)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtOilMotors10WFour: String? =MyApp.getInstance().resources.getString(R.string.msg_oilmotors_10w4)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtFiftyThree: String? = MyApp.getInstance().resources.getString(R.string.lbl_53)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txt12304: String? = MyApp.getInstance().resources.getString(R.string.msg_12304)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txt35304: String? = MyApp.getInstance().resources.getString(R.string.lbl_35_304)

)
