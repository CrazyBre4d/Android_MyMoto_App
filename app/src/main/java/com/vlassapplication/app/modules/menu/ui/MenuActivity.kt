package com.vlassapplication.app.modules.menu.ui

import androidx.activity.viewModels
import com.vlassapplication.app.R
import com.vlassapplication.app.appcomponents.base.BaseActivity
import com.vlassapplication.app.databinding.ActivityMenuBinding
import com.vlassapplication.app.modules.menu.`data`.viewmodel.MenuVM
import com.vlassapplication.app.modules.menuconsumables.ui.MenuConsumablesActivity
import com.vlassapplication.app.modules.menumain.ui.MenuMainActivity
import com.vlassapplication.app.modules.menusettings.ui.MenuSettingsActivity
import kotlin.String
import kotlin.Unit

class MenuActivity : BaseActivity<ActivityMenuBinding>(R.layout.activity_menu) {
  private val viewModel: MenuVM by viewModels<MenuVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.menuVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.frameMyBambax.setOnClickListener {
      val destIntent = MenuMainActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.frameSuppliers.setOnClickListener {
      val destIntent = MenuConsumablesActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.frameMyBambax1.setOnClickListener {
      val destIntent = MenuSettingsActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "MENU_ACTIVITY"

  }
}
