package com.leandroid.formula1.more

import android.content.Intent
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.leandroid.formula1.R
import com.leandroid.formula1.databinding.MoreFragmentBinding
import com.leandroid.formula1.info.InfoActivity

class MoreFragment : Fragment() {

    private lateinit var binding: MoreFragmentBinding
    private  val viewModel : MoreViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.more_fragment, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnAbout.setOnClickListener {
            var intent = Intent(activity, InfoActivity::class.java)
            intent.putExtra("INFO_TYPE", "about")
            startActivity(intent)
        }

        binding.btnPolicyPrivacidad.setOnClickListener {
            var intent = Intent(activity, InfoActivity::class.java)
            intent.putExtra("INFO_TYPE", "privacyPolicy")
            startActivity(intent)
        }

        binding.btnTermOfUse.setOnClickListener {
            var intent = Intent(activity, InfoActivity::class.java)
            intent.putExtra("INFO_TYPE", "termOfUse")
            startActivity(intent)
        }
    }
}