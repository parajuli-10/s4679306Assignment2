package com.example.s4679306assignment2.ui.dashboard

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.s4679306assignment2.data.remote.DashboardEntity
import com.example.s4679306assignment2.databinding.ItemEntityBinding

class EntityAdapter(
    private val onClick: (DashboardEntity) -> Unit
) : ListAdapter<DashboardEntity, EntityAdapter.VH>(Diff) {

    object Diff : DiffUtil.ItemCallback<DashboardEntity>() {
        override fun areItemsTheSame(o: DashboardEntity, n: DashboardEntity) =
            o.property1 == n.property1 && o.property2 == n.property2
        override fun areContentsTheSame(o: DashboardEntity, n: DashboardEntity) = o == n
    }

    inner class VH(val b: ItemEntityBinding) : RecyclerView.ViewHolder(b.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val b = ItemEntityBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return VH(b)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val item = getItem(position)
        holder.b.tvTitle.text = item.property1 ?: "(no property1)"
        holder.b.tvSubtitle.text = item.property2 ?: "(no property2)"
        holder.itemView.setOnClickListener { onClick(item) }
    }
}
