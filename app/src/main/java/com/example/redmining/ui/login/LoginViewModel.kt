package com.example.redmining.ui.login

import android.util.Log
import android.util.Patterns
import androidx.databinding.Bindable
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.redmining.model.ValidationError
import com.example.redmining.repository.MainRepository
import androidx.databinding.ObservableField





class LoginViewModel(
    private val repository: MainRepository
): ViewModel() {

    var clientUrl = MutableLiveData<String?>()
    var username = MutableLiveData<String?>()
    var password = MutableLiveData<String?>()
//    private var _clientUrl = ObservableField("")
//    private var _username = ObservableField("")
//    private var _password = ObservableField("")
    private val validationError = ValidationError()

//    val clientUrl: LiveData<String?>
//        get() = _clientUrl
//    val username: LiveData<String?>
//        get() = _username
//    val password: LiveData<String?>
//        get() = _password

//    val clientUrl: String = _clientUrl.toString().trim()
//    val username: String = _username.toString().trim()
//    val password: String = clientUrl.toString().trim()

    fun onClick(){
        val clientUrl = clientUrl.toString().trim()
        val username = username.toString().trim()
        val password = password.toString().trim()
        Log.d("Click", "Click: $clientUrl $username $password")
        validateCredentials(clientUrl, username, password)
    }

    private fun validateCredentials(clientUrl: String, username: String, password: String): Boolean {

        if(!Patterns.WEB_URL.matcher(clientUrl).matches() || clientUrl.isEmpty()) {
            validationError.isUrlValid = false
            return false
        }
        if(username.isEmpty()) {
            validationError.isUsernameValid = false
            return false
        }
        if(password.isEmpty()) {
            validationError.isUsernameValid = false
            return false
        }
        return true
    }

}