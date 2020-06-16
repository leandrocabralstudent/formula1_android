package com.leandroid.formula1.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.leandroid.formula1.R
import com.leandroid.formula1.databinding.HomeFragmentBinding
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

import org.koin.android.viewmodel.ext.android.viewModel


class HomeFragment : Fragment() {

    private lateinit var binding: HomeFragmentBinding

    val viewModel: HomeViewModel by viewModel<HomeViewModel>()

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

        binding.cardTop.setImage("https://jmonline.com.br/userfiles/image/2020/05/10/Lewis-Hamilton-interna.jpg")
        binding.cardTop.setName("1º Lewis Hamilton")
        binding.cardTop.setPoint("577 pts -  Mercedes")

       viewModel.getPilot()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSuccess { pilots ->
                Log.i("pilot",pilots.toString())
            }.doOnError {

            }.subscribe()

    }

}