package com.vlassapplication.app.modules.changemoto.`data`.model

import com.vlassapplication.app.R
import com.vlassapplication.app.appcomponents.di.MyApp
import kotlin.String

data class ChangeMotoModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtTextOne: String? = MyApp.getInstance().resources.getString(R.string.msg5)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtText: String? = MyApp.getInstance().resources.getString(R.string.lbl4)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtTextOne1: String? = MyApp.getInstance().resources.getString(R.string.lbl5)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtTextTwo: String? = MyApp.getInstance().resources.getString(R.string.lbl6)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtTextThree: String? = MyApp.getInstance().resources.getString(R.string.lbl7)

)
