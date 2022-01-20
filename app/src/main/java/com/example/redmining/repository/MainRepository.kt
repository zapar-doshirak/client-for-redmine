package com.example.redmining.repository

import android.app.Application
import android.text.TextUtils
import android.util.Patterns
import android.widget.Toast
import androidx.lifecycle.LiveData
import com.example.redmining.networking.ClientApi
import com.example.redmining.networking.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException

class MainRepository(
    private val api: ClientApi
) {

//    fun validateCredentials(clientUrl: String, username: String, password: String): Boolean {
//
//        if(!Patterns.WEB_URL.matcher(clientUrl).matches() || clientUrl.isEmpty()) {
//            Toast.makeText(, "Invalid URL", Toast.LENGTH_SHORT).show()
//            return false
//        }
//        if(username.isEmpty()) {
//            return false
//        }
//        if(password.isEmpty()) {
//            return false
//        }
//        return true
//    }


    suspend fun login(
        clientUrl: String,
        email: String,
        password: String
    ) = safeApiCall {
        api.login(clientUrl, email, password)
    }

    //it's possible to replace this to base repository and then extend from it
    private suspend fun <T> safeApiCall(
        apiCall: suspend () -> T
    ): Resource<T> {
        return withContext(Dispatchers.IO){
            try {
                Resource.Success(apiCall.invoke())
            } catch (throwable: Throwable){
                //check type of error
                when(throwable){
                    is HttpException -> {
                        Resource.Failure(false, throwable.code(), throwable.response()?.errorBody())
                    }
                    else -> {
                        Resource.Failure(true, null, null)
                    }
                }
            }
        }
    }

}