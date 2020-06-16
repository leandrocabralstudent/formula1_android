package com.leandroid.formula1.champion

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.leandroid.domain.model.Champion
import com.leandroid.domain.model.Race
import com.leandroid.formula1.R
import com.leandroid.formula1.databinding.ChampionFragmentBinding
import com.leandroid.formula1.databinding.HomeFragmentBinding
import com.leandroid.formula1.home.HomeViewModel
import com.leandroid.formula1.race.RaceAdapter

class ChampionFragment : Fragment() {

    private lateinit var binding: ChampionFragmentBinding
    private  val viewModel : ChampionViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.champion_fragment, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    fun mountList(champions: List<Champion>) {
        binding.recChampion.setHasFixedSize(true)
        val llm = LinearLayoutManager(context)
        llm.orientation = LinearLayoutManager.VERTICAL
        binding.recChampion.layoutManager = llm

        val adapter = ChampionAdapter(champions)
        binding.recChampion.adapter = adapter
    }

}