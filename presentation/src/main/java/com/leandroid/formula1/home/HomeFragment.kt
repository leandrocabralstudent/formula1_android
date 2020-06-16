package com.leandroid.formula1.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.leandroid.formula1.R
import com.leandroid.formula1.databinding.HomeFragmentBinding
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.koin.android.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    private lateinit var binding: HomeFragmentBinding
    private val viewModel: HomeViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.home_fragment, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getPilot()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSuccess { pilots ->
                val pilotLeader = pilots.first()
                binding.cardTop.setImage(pilotLeader.photo)
                binding.cardTop.setName(
                    resources.getString(
                        R.string.name_widget_card_top,
                        pilotLeader.name
                    )
                )

                binding.cardTop.setPoint(
                    resources.getString(
                        R.string.point_widget_card_top,
                        pilotLeader.point, pilotLeader.team
                    )
                )

                val pilotsOther = pilots.filter { id > 1 }
                binding.cardTable.mountList(pilotsOther)

            }.doOnError { error ->

            }.subscribe()
    }
}