package com.vlassapplication.app.modules.menumain.ui

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.vlassapplication.app.R
import com.vlassapplication.app.appcomponents.base.BaseActivity
import com.vlassapplication.app.appcomponents.di.MyApp
import com.vlassapplication.app.databinding.ActivityMenuMainBinding
import com.vlassapplication.app.modules.changemoto.ui.ChangeMotoActivity
import com.vlassapplication.app.modules.menuconsumables.ui.MenuConsumablesActivity
import com.vlassapplication.app.modules.menumain.`data`.viewmodel.MenuMainVM
import com.vlassapplication.app.modules.menusettings.ui.MenuSettingsActivity
import com.vlassapplication.app.modules.updatekmage.ui.UpdateKmageActivity
import com.vlassapplication.app.repositories.KmageDAO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.String
import kotlin.Unit

class MenuMainActivity : BaseActivity<ActivityMenuMainBinding>(R.layout.activity_menu_main) {
  private val viewModel: MenuMainVM by viewModels<MenuMainVM>()
  lateinit var kmageDAO: KmageDAO

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.menuMainVM = viewModel
    kmageDAO = MyApp.getInstance().database?.kmageDAO()!!
    GlobalScope.launch(Dispatchers.IO) {
      viewModel.setCurrentKmageText(kmageDAO.currentKmage.kmage.toString())
    }
  }

  override fun setUpClicks(): Unit {
    binding.btnOne.setOnClickListener {
      val destIntent = UpdateKmageActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.frameMyBambax.setOnClickListener {
      vibrate()
    }
    binding.frameSuppliers.setOnClickListener {
      vibrate()
      val destIntent = MenuConsumablesActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.frameMySettings.setOnClickListener {
      vibrate()
      val destIntent = MenuSettingsActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "MENU_MAIN_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, MenuMainActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
  private fun vibrate() {
    val vibrator = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator

    // Проверяем, поддерживается ли вибрация на устройстве
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
      vibrator.vibrate(VibrationEffect.createOneShot(10, VibrationEffect.DEFAULT_AMPLITUDE))
    } else {
      // Для более старых устройств
      @Suppress("DEPRECATION")
      vibrator.vibrate(100)
    }
  }
}
