package com.leandroid.formula1.widget.cardTableView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.leandroid.domain.model.Pilot
import com.leandroid.formula1.R

class CardTableViewAdapter(var pilots: List<Pilot>)
    : RecyclerView.Adapter<CardTableViewAdapter.CardTableViewHolder>() {

    override fun getItemCount(): Int {
        return pilots.size
    }

    override fun onBindViewHolder(cardTableViewHolder: CardTableViewHolder, i: Int) {
        val name = cardTableViewHolder.vDescricao

    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): CardTableViewHolder {
        val itemView: View = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.widget_card_table_item, viewGroup, false)
        return CardTableViewHolder(itemView)
    }

    class CardTableViewHolder(v: View) : ViewHolder(v) {
        var vDescricao: TextView
        init {
            vDescricao = v.findViewById(R.id.tv_name)

        }
    }
}