package com.vlassapplication.app.modules.addconsumable.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.vlassapplication.app.R
import com.vlassapplication.app.appcomponents.base.BaseActivity
import com.vlassapplication.app.appcomponents.di.MyApp
import com.vlassapplication.app.databinding.ActivityAddConsumableBinding
import com.vlassapplication.app.entities.Consumable
import com.vlassapplication.app.modules.addconsumable.`data`.viewmodel.AddConsumableVM
import com.vlassapplication.app.modules.menuconsumables.data.model.ListtwoRowModel
import com.vlassapplication.app.modules.menuconsumables.ui.MenuConsumablesActivity
import com.vlassapplication.app.repositories.ConsumableDAO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.String
import kotlin.Unit
import com.vlassapplication.app.modules.menuconsumables.ui.ListtwoAdapter
import com.vlassapplication.app.repositories.KmageDAO


class AddConsumableActivity :
    BaseActivity<ActivityAddConsumableBinding>(R.layout.activity_add_consumable) {
  private val viewModel: AddConsumableVM by viewModels<AddConsumableVM>()
 lateinit var kmageDAO: KmageDAO
 lateinit var consumableDAO: ConsumableDAO

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.addConsumableVM = viewModel
  }

  override fun setUpClicks(): Unit {

    binding.btn.setOnClickListener {
      val destIntent = MenuConsumablesActivity.getIntent(this, null)
      startActivity(destIntent)

      val editTextName = findViewById<EditText>(R.id.viewRectangleThree)
      val editTextDesc = findViewById<EditText>(R.id.viewRectangleThreeOne)
      val editTextTimeUsage = findViewById<EditText>(R.id.viewRectangleThreeTwo)
      val editTextMoreDesc = findViewById<EditText>(R.id.viewRectangleThreeThree)

      consumableDAO = MyApp.getInstance().database?.consumableDAO()!!
      kmageDAO = MyApp.getInstance().database?.kmageDAO()!!

      GlobalScope.launch(Dispatchers.IO) {
        val name = editTextName.text.toString()
      val description = editTextDesc.text.toString()
      val timeUsage = editTextTimeUsage.text.toString().toInt()
      val moreDescription = editTextMoreDesc.text.toString()
      val primaryKmage = kmageDAO.currentKmage.kmage

      consumableDAO.addConsumable(Consumable(name, description,timeUsage,moreDescription, primaryKmage ))
      Log.d("Database", "Consumable added to the database: $name");
        val updatedList = consumableDAO.allConsumables
        withContext(Dispatchers.Main) {
          viewModel.updateList(updatedList)
        }
      }

    }
  }

  companion object {
    const val TAG: String = "ADD_CONSUMABLE_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, AddConsumableActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
