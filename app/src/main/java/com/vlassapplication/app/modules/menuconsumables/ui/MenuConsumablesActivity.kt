package com.vlassapplication.app.modules.menuconsumables.ui

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.util.Log
import android.view.View
import android.widget.EditText
import androidx.activity.viewModels
import com.vlassapplication.app.R
import com.vlassapplication.app.appcomponents.base.BaseActivity
import com.vlassapplication.app.appcomponents.di.MyApp
import com.vlassapplication.app.databinding.ActivityMenuConsumablesBinding
import com.vlassapplication.app.entities.Consumable
import com.vlassapplication.app.modules.addconsumable.ui.AddConsumableActivity
import com.vlassapplication.app.modules.menuconsumables.data.model.ListtwoRowModel
import com.vlassapplication.app.modules.menuconsumables.data.viewmodel.MenuConsumablesVM
import com.vlassapplication.app.modules.menumain.ui.MenuMainActivity
import com.vlassapplication.app.modules.menusettings.ui.MenuSettingsActivity
import com.vlassapplication.app.repositories.ConsumableDAO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class MenuConsumablesActivity :
    BaseActivity<ActivityMenuConsumablesBinding>(R.layout.activity_menu_consumables) {
  private val viewModel: MenuConsumablesVM by viewModels<MenuConsumablesVM>()
  lateinit var consumableDAO: ConsumableDAO

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    val listtwoAdapter = ListtwoAdapter(viewModel.listtwoList.value ?: mutableListOf())
    binding.recyclerListtwo.adapter = listtwoAdapter
    listtwoAdapter.setOnItemClickListener(
      object : ListtwoAdapter.OnItemClickListener {
        override fun onItemClick(view: View, position: Int, item: ListtwoRowModel) {
          onClickRecyclerListtwo(view, position, item)
        }
      }
    )
    viewModel.listtwoList.observe(this) {
      listtwoAdapter.updateData(it)
    }
    binding.menuConsumablesVM = viewModel

    consumableDAO = MyApp.getInstance().database?.consumableDAO()!!
    GlobalScope.launch(Dispatchers.IO) {
// Получение всех записей из базы данных
      val consumableList: List<Consumable> = consumableDAO.getAllConsumables()

      // Создайте список данных для адаптера
      val listData: MutableList<ListtwoRowModel> = mutableListOf()

      // Заполните listData значениями из базы данных
      for (consumable in consumableList) {
        val listtwoRowModel = ListtwoRowModel(
          txtTwo = consumable.name,
          txtOilMotors10WFour = consumable.description,
          txtFiftyThree = "53%" ,
          txt12304 = "Осталось 165 км",
          txt35304 = consumable.useTime.toString() + " км"// Пример, вы можете использовать другие поля из consumable
        )
        listData.add(listtwoRowModel)
      }

      // Обновите данные в адаптере
      listtwoAdapter.updateData(listData)


    }

  }
  override fun setUpClicks(): Unit {
    binding.btnBtnAdd.setOnClickListener {
      val destIntent = AddConsumableActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.frameMyBambax.setOnClickListener {
      vibrate()
      val destIntent = MenuMainActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.frameSuppliers.setOnClickListener {
      vibrate()
    }
    binding.frameMySettings.setOnClickListener {
      vibrate()
      val destIntent = MenuSettingsActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  fun onClickRecyclerListtwo(
    view: View,
    position: Int,
    item: ListtwoRowModel
  ): Unit {
    when(view.id) {
    }
  }

  companion object {
    const val TAG: String = "MENU_CONSUMABLES_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, MenuConsumablesActivity::class.java)
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
