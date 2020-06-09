package com.leandroid.formula1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.leandroid.data.network.race.RemoteRaceService
import com.leandroid.data.network.service.RaceService
import com.leandroid.formula1.champion.ChampionFragment
import com.leandroid.formula1.databinding.MainActivityBinding
import com.leandroid.formula1.home.HomeFragment
import com.leandroid.formula1.more.MoreFragment
import com.leandroid.formula1.race.RaceFragment
import com.leandroid.formula1.widget.NavigationBottom
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private lateinit var binding: MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.main_activity)

        binding.navigationBottom.selectedButton.doOnNext {section->
            navigateToSection(section)
        }.doOnError {
            Toast.makeText(this, "Erro ao trocar de Fragment", Toast.LENGTH_LONG).show()
        }.subscribe()
    }

    private fun navigateToSection(section: NavigationBottom.Section) {
        val selectedSectionFragment: Fragment = when (section) {
            NavigationBottom.Section.HOME -> HomeFragment()
            NavigationBottom.Section.RACE -> RaceFragment()
            NavigationBottom.Section.CHAMPION -> ChampionFragment()
            NavigationBottom.Section.MORE -> MoreFragment()
        }

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_main, selectedSectionFragment)
            .addToBackStack(selectedSectionFragment::class.java.simpleName)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            .commit()
    }
}