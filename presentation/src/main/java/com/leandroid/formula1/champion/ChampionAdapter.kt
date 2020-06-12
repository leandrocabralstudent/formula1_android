package com.leandroid.formula1.champion

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.leandroid.domain.model.Pilot
import com.leandroid.formula1.R
import com.leandroid.formula1.widget.CardCommomView


class ChampionAdapter (var pilots: List<Pilot>)
    : RecyclerView.Adapter<ChampionAdapter.ChampionViewHolder>() {

    override fun getItemCount(): Int {
        return pilots.size
    }

    override fun onBindViewHolder(championViewHolder: ChampionViewHolder, i: Int) {
        val card = championViewHolder.vCardCommomView

    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ChampionViewHolder {
        val itemView: View = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.race_item, viewGroup, false)
        return ChampionViewHolder(itemView)
    }

    class ChampionViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        var vCardCommomView: CardCommomView
        init {
            vCardCommomView = v.findViewById(R.id.ccv_champion)

        }
    }
}