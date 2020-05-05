package com.lingdtkhe.testapp.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.lingdtkhe.testapp.R
import com.lingdtkhe.testapp.common.util.loadImage
import com.lingdtkhe.testapp.entities.TvProgramVM
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_tv_program.view.*

/**
 * Just Adapter...
 */
class TvProgramAdapter(private val listener: TvProgramListener) :
    RecyclerView.Adapter<TvProgramAdapter.VH>() {
    private val items: MutableList<TvProgramVM> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH =
        VH(
            LayoutInflater.from(parent.context)
                .inflate(
                    R.layout.item_tv_program,
                    parent,
                    false
                )
        )

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(items[holder.adapterPosition])
    }

    fun setData(newItems: List<TvProgramVM>) {
        with(items) {
            clear()
            addAll(newItems)
        }
        notifyDataSetChanged()
    }

    inner class VH(override val containerView: View) : RecyclerView.ViewHolder(containerView),
        LayoutContainer {
        fun bind(item: TvProgramVM) {
            containerView.setOnClickListener { listener.onClick(item, containerView.iv_item) }
            containerView.iv_item.loadImage(item.imageUrl)
        }
    }

    interface TvProgramListener {
        fun onClick(item: TvProgramVM, view: ImageView)
    }
}