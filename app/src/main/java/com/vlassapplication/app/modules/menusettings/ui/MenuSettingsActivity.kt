package com.vlassapplication.app.modules.menusettings.ui

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import androidx.activity.viewModels
import com.vlassapplication.app.R
import com.vlassapplication.app.appcomponents.base.BaseActivity
import com.vlassapplication.app.databinding.ActivityMenuSettingsBinding
import com.vlassapplication.app.modules.changemoto.ui.ChangeMotoActivity
import com.vlassapplication.app.modules.menuconsumables.ui.MenuConsumablesActivity
import com.vlassapplication.app.modules.menumain.ui.MenuMainActivity
import com.vlassapplication.app.modules.menusettings.`data`.viewmodel.MenuSettingsVM
import kotlin.String
import kotlin.Unit

class MenuSettingsActivity :
    BaseActivity<ActivityMenuSettingsBinding>(R.layout.activity_menu_settings) {
  private val viewModel: MenuSettingsVM by viewModels<MenuSettingsVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.menuSettingsVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.btn1.setOnClickListener {
      vibrate()
      val destIntent = ChangeMotoActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.frameMyBambax.setOnClickListener {
      vibrate()
      val destIntent = MenuMainActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.frameSuppliers.setOnClickListener {
      vibrate()
      val destIntent = MenuConsumablesActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.frameMyBambax1.setOnClickListener {
      vibrate()
    }

  }

  companion object {
    const val TAG: String = "MENU_SETTINGS_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, MenuSettingsActivity::class.java)
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
