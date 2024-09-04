package com.esports.letsbuy.Views.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.esports.letsbuy.R
import com.esports.letsbuy.databinding.FragmentLoginBinding
import com.esports.letsbuy.isEmpty


class LoginFragment : Fragment() {
    lateinit var binding: FragmentLoginBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater, container, false)

        binding.btnLogin.setOnClickListener {
            setClickListener()
        }

        binding.btnRegister.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }

        return binding.root
    }

    private fun setClickListener() {
        with(binding) {
            etEmail.isEmpty()
            etPassword.isEmpty()

            if (!etEmail.isEmpty() && !etPassword.isEmpty()) {
                findNavController().navigate(R.id.action_loginFragment_to_dashBoardFragment)
            } else {
                Toast.makeText(context, "Input can not be empty", Toast.LENGTH_SHORT).show()
            }
        }
    }

}