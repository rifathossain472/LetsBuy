package com.esports.letsbuy.Views.register

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.esports.letsbuy.core.DataState
import com.esports.letsbuy.data.AuthService

class RegistrationViewModel : ViewModel() {

    private val _registrationResponse = MutableLiveData<DataState<User>>()
    val registrationResponse: LiveData<DataState<User>> = _registrationResponse


    fun userRegistration(user: User) {

        _registrationResponse.postValue(DataState.Loading())

        val authService = AuthService()

        authService.userRegistration(user).addOnSuccessListener {

            _registrationResponse.postValue(DataState.Success(user))

            Log.d("TAG", "userRegistration: Success ")
        }.addOnFailureListener {

            _registrationResponse.postValue(DataState.Error(it.message))

            Log.d("TAG", "userRegistration: ${it.message} ")
        }

    }

}