package com.vlassapplication.app.modules.menuconsumables.`data`.model

import com.vlassapplication.app.R
import com.vlassapplication.app.appcomponents.di.MyApp
import java.math.BigDecimal
import java.math.RoundingMode
import kotlin.String
import kotlin.math.roundToInt

data class ListtwoRowModel(
  var name: String,
  var description: String?,
  var useTime: Int,
  var primaryKmage: Int,
  var currentKmage: Int
) {
  var useTimeText: String = "10000"
  var deadKmage: Int = 35000
  var deadKmageText: String = "35000"
  var leftKm: Int = 2000
  var leftKmText: String = "Осталось 2000 км"
  var progress: Double = 0.6
  var progressText: String? = "60%"

  init {
    useTimeText = "$useTime"
    deadKmage = primaryKmage + useTime
    deadKmageText = "$deadKmage"
    leftKm = deadKmage - currentKmage
    leftKmText =  "Осталось $leftKm км"
    progress = (useTime-leftKm).toDouble()/useTime.toDouble()
    progress = BigDecimal(progress).setScale(2, RoundingMode.HALF_EVEN).toDouble()
    progressText = (progress*100).roundToInt().toString() + "%"
  }

}
