package com.vlassapplication.app.modules.changemoto.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.vlassapplication.app.R
import com.vlassapplication.app.appcomponents.base.BaseActivity
import com.vlassapplication.app.databinding.ActivityChangeMotoBinding
import com.vlassapplication.app.modules.changemoto.`data`.viewmodel.ChangeMotoVM
import com.vlassapplication.app.modules.menusettings.ui.MenuSettingsActivity
import kotlin.String
import kotlin.Unit

class ChangeMotoActivity : BaseActivity<ActivityChangeMotoBinding>(R.layout.activity_change_moto) {
  private val viewModel: ChangeMotoVM by viewModels<ChangeMotoVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.changeMotoVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.btn.setOnClickListener {
      val destIntent = MenuSettingsActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "CHANGE_MOTO_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, ChangeMotoActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
