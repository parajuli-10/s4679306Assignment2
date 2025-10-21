package com.example.s4679306assignment2.ui.dashboard

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.s4679306assignment2.data.remote.DashboardEntity
import com.example.s4679306assignment2.databinding.ItemEntityBinding

class EntityAdapter(
    private val onClick: (DashboardEntity) -> Unit
) : ListAdapter<DashboardEntity, EntityAdapter.VH>(diff) {

    companion object {
        private val diff = object : DiffUtil.ItemCallback<DashboardEntity>() {
            override fun areItemsTheSame(o: DashboardEntity, n: DashboardEntity) =
                o.property1 == n.property1 && o.property2 == n.property2
            override fun areContentsTheSame(o: DashboardEntity, n: DashboardEntity) = o == n
        }
    }

    inner class VH(val b: ItemEntityBinding) : RecyclerView.ViewHolder(b.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val binding = ItemEntityBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return VH(binding)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val item = getItem(position)
        holder.b.tvTitle.text = item.property1 ?: "(no property1)"
        holder.b.tvSubtitle.text = item.property2 ?: "(no property2)"
        // description intentionally NOT shown on the card (per spec)
        holder.itemView.setOnClickListener { onClick(item) }
    }
}
