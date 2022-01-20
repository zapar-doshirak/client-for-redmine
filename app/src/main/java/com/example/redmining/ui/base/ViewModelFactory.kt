package com.example.redmining.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.redmining.repository.MainRepository
import com.example.redmining.ui.login.LoginViewModel
import java.lang.IllegalArgumentException

class ViewModelFactory(
    private val repository: MainRepository
): ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when{
            modelClass.isAssignableFrom(LoginViewModel::class.java) -> LoginViewModel(repository) as T
            //other viewModels ...
            else -> throw IllegalArgumentException("ViewModelClass Not Found")
        }
    }

}