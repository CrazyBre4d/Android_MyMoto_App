package com.vlassapplication.app.modules.updatekmage.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.vlassapplication.app.R
import com.vlassapplication.app.appcomponents.base.BaseActivity
import com.vlassapplication.app.databinding.ActivityUpdateKmageBinding
import com.vlassapplication.app.modules.menumain.ui.MenuMainActivity
import com.vlassapplication.app.modules.updatekmage.`data`.viewmodel.UpdateKmageVM
import kotlin.String
import kotlin.Unit

class UpdateKmageActivity : BaseActivity<ActivityUpdateKmageBinding>(R.layout.activity_update_kmage)
    {
  private val viewModel: UpdateKmageVM by viewModels<UpdateKmageVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.updateKmageVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.btn.setOnClickListener {
      val destIntent = MenuMainActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.imageClose.setOnClickListener {
      val destIntent = MenuMainActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "UPDATE_KMAGE_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, UpdateKmageActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
