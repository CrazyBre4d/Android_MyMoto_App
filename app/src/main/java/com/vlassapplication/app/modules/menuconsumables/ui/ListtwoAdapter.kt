package com.vlassapplication.app.modules.menuconsumables.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vlassapplication.app.R
import com.vlassapplication.app.databinding.RowListtwoBinding
import com.vlassapplication.app.modules.menuconsumables.`data`.model.ListtwoRowModel
import kotlin.Int
import kotlin.collections.List

class ListtwoAdapter(
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
  }

  override fun getItemCount(): Int = list.size

  public fun updateData(newData: List<ListtwoRowModel>) {
    list = newData
    notifyDataSetChanged()
  }

  fun setOnItemClickListener(clickListener: OnItemClickListener) {
    this.clickListener = clickListener
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
  }
}
