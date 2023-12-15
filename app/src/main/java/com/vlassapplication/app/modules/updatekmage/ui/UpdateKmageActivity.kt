package com.vlassapplication.app.modules.updatekmage.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import androidx.activity.viewModels
import com.vlassapplication.app.R
import com.vlassapplication.app.appcomponents.base.BaseActivity
import com.vlassapplication.app.appcomponents.di.MyApp
import com.vlassapplication.app.databinding.ActivityUpdateKmageBinding
import com.vlassapplication.app.entities.Consumable
import com.vlassapplication.app.entities.Kmage
import com.vlassapplication.app.modules.menumain.ui.MenuMainActivity
import com.vlassapplication.app.modules.updatekmage.`data`.viewmodel.UpdateKmageVM
import com.vlassapplication.app.repositories.ConsumableDAO
import com.vlassapplication.app.repositories.KmageDAO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.String
import kotlin.Unit

class UpdateKmageActivity : BaseActivity<ActivityUpdateKmageBinding>(R.layout.activity_update_kmage)
    {
  private val viewModel: UpdateKmageVM by viewModels<UpdateKmageVM>()
  lateinit var kmageDAO: KmageDAO

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.updateKmageVM = viewModel
    kmageDAO = MyApp.getInstance().database?.kmageDAO()!!
    GlobalScope.launch(Dispatchers.IO) {
      viewModel.setCurrentKmageText(kmageDAO.currentKmage.kmage.toString())
    }
  }

  override fun setUpClicks(): Unit {
    binding.btn.setOnClickListener {
      val destIntent = MenuMainActivity.getIntent(this, null)
      startActivity(destIntent)

      val editTextName = findViewById<EditText>(R.id.txtZipcode)

      kmageDAO = MyApp.getInstance().database?.kmageDAO()!!

      GlobalScope.launch(Dispatchers.IO) {
        val textkmage = editTextName.text.toString()
        kmageDAO.addKmage( Kmage(textkmage.toInt()))
        val updatedKmage = kmageDAO.currentKmage
        withContext(Dispatchers.Main) {
          viewModel.updateKmage(updatedKmage)
        }

      }


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
