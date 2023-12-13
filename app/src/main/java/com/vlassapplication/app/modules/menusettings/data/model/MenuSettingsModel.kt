package com.vlassapplication.app.modules.menusettings.`data`.model

import com.vlassapplication.app.R
import com.vlassapplication.app.appcomponents.di.MyApp
import kotlin.String

data class MenuSettingsModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtEight: String? = MyApp.getInstance().resources.getString(R.string.lbl14)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtNine: String? = MyApp.getInstance().resources.getString(R.string.lbl11)
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
  var txtTen: String? = MyApp.getInstance().resources.getString(R.string.lbl16)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtEleven: String? = MyApp.getInstance().resources.getString(R.string.msg6)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtTwelve: String? = MyApp.getInstance().resources.getString(R.string.msg7)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtThirteen: String? = MyApp.getInstance().resources.getString(R.string.lbl18)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtFourteen: String? = MyApp.getInstance().resources.getString(R.string.lbl18)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtFifteen: String? = MyApp.getInstance().resources.getString(R.string.msg8)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtSixteen: String? = MyApp.getInstance().resources.getString(R.string.lbl19)

)
