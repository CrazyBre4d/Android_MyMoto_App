package com.vlassapplication.app.modules.menuconsumables.ui

import android.content.Context
import android.util.DisplayMetrics
import android.view.WindowManager
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vlassapplication.app.R
import com.vlassapplication.app.databinding.RowListtwoBinding
import com.vlassapplication.app.modules.menuconsumables.`data`.model.ListtwoRowModel
import kotlin.Int
import kotlin.collections.List
import kotlin.math.roundToInt

class ListtwoAdapter(
  var context: Context,
  var list: List<ListtwoRowModel>
) : RecyclerView.Adapter<ListtwoAdapter.RowListtwoVH>() {
  private var clickListener: OnItemClickListener? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowListtwoVH {
    val view=LayoutInflater.from(parent.context).inflate(R.layout.row_listtwo,parent,false)
    return RowListtwoVH(view)
  }

  override fun onBindViewHolder(holder: RowListtwoVH, position: Int) {
    val listtwoRowModel = list[position]
    holder.binding.listtwoRowModel = listtwoRowModel
    var progress = listtwoRowModel.progress
    if (progress < 0.1)
      progress = 0.1
    else if(progress > 1.0 )
      progress = 1.0
    val newWidth = ((getScreenWidth(context)-pxToDp(31F)*2)*progress).roundToInt()
    holder.resizeProgressBar(newWidth)

  }

  override fun getItemCount(): Int = list.size

  public fun updateData(newData: List<ListtwoRowModel>) {
    list = newData
    notifyDataSetChanged()
  }

  fun setOnItemClickListener(clickListener: OnItemClickListener) {
    this.clickListener = clickListener
  }

  private fun getScreenWidth(context: Context): Int {
    val displayMetrics = DisplayMetrics()
    val windowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
    windowManager.defaultDisplay.getMetrics(displayMetrics)
    return displayMetrics.widthPixels
  }


  fun pxToDp(px: Float): Float {
    val displayMetrics = DisplayMetrics()
    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX, px, displayMetrics)
  }

  interface OnItemClickListener {
    fun onItemClick(
      view: View,
      position: Int,
      item: ListtwoRowModel
    ) {
    }
  }

  inner class RowListtwoVH(
    view: View
  ) : RecyclerView.ViewHolder(view) {
    val binding: RowListtwoBinding = RowListtwoBinding.bind(itemView)
    fun resizeProgressBar(newWidth: Int) {
      binding.progressBarView.layoutParams.width = newWidth
    }
  }
}
