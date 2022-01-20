package com.example.redmining.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.redmining.R
import com.example.redmining.databinding.FragmentLoginBinding
import com.example.redmining.networking.ClientApi
import com.example.redmining.repository.MainRepository
import com.example.redmining.ui.base.BaseFragment


class LoginFragment : BaseFragment<LoginViewModel, FragmentLoginBinding, MainRepository>() {

    //here all fragment logic
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }


    //override functions from BaseFragment

    override fun getViewModel() = LoginViewModel::class.java

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentLoginBinding.inflate(inflater, container, false)

    override fun getFragmentRepository() = MainRepository(remoteDataSource.buildApi(ClientApi::class.java))

}