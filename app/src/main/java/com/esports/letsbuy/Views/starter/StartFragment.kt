package com.esports.letsbuy.Views.starter

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.esports.letsbuy.R
import com.esports.letsbuy.base.BaseFragment
import com.esports.letsbuy.databinding.FragmentStartBinding


class StartFragment : BaseFragment<FragmentStartBinding>(FragmentStartBinding::inflate) {

    override fun allObserver() {

    }

    override fun setListener() {
        with(binding) {
            btnLogin.setOnClickListener {
                findNavController().navigate(R.id.action_startFragment_to_loginFragment)
            }

            btnRegister.setOnClickListener {
                findNavController().navigate(R.id.action_startFragment_to_registerFragment)
            }
        }
    }


}