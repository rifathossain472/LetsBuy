package com.esports.letsbuy.Views.register

import android.os.Bundle
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.widget.ToggleButton
import androidx.navigation.fragment.findNavController
import com.esports.letsbuy.R
import com.esports.letsbuy.databinding.FragmentRegisterBinding
import com.esports.letsbuy.isEmpty
import java.util.regex.Pattern


class RegisterFragment : Fragment() {
    private lateinit var binding: FragmentRegisterBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRegisterBinding.inflate(inflater, container, false)


        emailFocusListener()
        passwordFocusListener()

        binding.btnRegister.setOnClickListener {
            setListener()
        }
        return binding.root
    }

    /*private fun emailFocusListener() {
        binding.etEmail.setOnFocusChangeListener { _, focused ->
            if (!focused) {
                binding.emailContainer.helperText = validEmail()
            }
        }
    }

    private fun validEmail(): String? {

        val emailText = binding.etEmail.text.toString()
        if (!Patterns.EMAIL_ADDRESS.matcher(emailText).matches()) {
            return "Invalid Email Address"
        }
        return null
    }*/

    private fun emailFocusListener() {
        binding.etEmail.setOnFocusChangeListener { _, focused ->
            if (!focused) {
                binding.emailContainer.helperText = validEmail()
            }
        }
    }

    private fun validEmail(): String? {

        val emailText = binding.etEmail.text.toString()
        val pattern = "^[a-z0-9+_.-]+@[a-z.-]{4,7}\\.[a-z]{2,5}$"
        if (!emailText.matches(pattern.toRegex())) {
            return "Invalid Email Address\nEx: alpha@gmail.com"
        }
        return null
    }

    private fun passwordFocusListener() {
        binding.etPassword.setOnFocusChangeListener { _, focused ->
            if (!focused) {
                binding.passwordContainer.helperText = validPassword()
            }
        }
    }

    private fun validPassword(): String? {
        val passwordText = binding.etPassword.text.toString()

        if (passwordText.length < 8) {
            return "Minimum 8 Characters Required"
        }
        if (!passwordText.matches(".*[A-Z].*".toRegex())) {
            return "Must Contain 1 Upper Case Character"
        }
        if (!passwordText.matches(".*[a-z].*".toRegex())) {
            return "Must Contain 1 Lower Case Character"
        }
        if (!passwordText.matches(".*[0-9].*".toRegex())) {
            return "Must Contain 1 Digit Required"
        }
        if (!passwordText.matches(".*[!@#\$%^&*(),.?\":{}|<>].*".toRegex())) {
            return "Must Contain 1 Special Character Required"
        }

        return null
    }

    private fun setListener() {
        with(binding) {
            etName.isEmpty()
            etEmail.isEmpty()
            etPassword.isEmpty()

            if (!etName.isEmpty() && !etEmail.isEmpty() && !etPassword.isEmpty()) {
                submitForm()
            }
        }
    }

    private fun submitForm() {

        val validName = binding.nameContainer.helperText == null
        val validEmail = binding.emailContainer.helperText == null
        val validPassword = binding.passwordContainer.helperText == null

        if (validName && validEmail && validPassword) {
            registerUser()
        } else {
            invalidForm()
        }
    }

    private fun invalidForm() {
        Toast.makeText(context, "Invalid Input", Toast.LENGTH_SHORT).show()
    }

    private fun registerUser() {
        Toast.makeText(context, "Registration Successfully", Toast.LENGTH_SHORT).show()
        findNavController().navigate(R.id.action_registerFragment_to_dashBoardFragment)
    }

}




