package com.chsltutorials.mvvmsample.ui.auth

import android.view.View
import androidx.lifecycle.ViewModel
import com.chsltutorials.mvvmsample.data.repositories.UserRepository

class AuthViewModel : ViewModel() {

    var authListener : AuthListener? = null
    var email : String ? = null
    var password : String ? = null

    fun onLoginButtonClick(view : View){
        authListener?.onStarted()
        if(email.isNullOrEmpty() || password.isNullOrEmpty()){
            authListener?.onFailure("email ou senha inválida")
            return
        }

        val loginResponse = UserRepository().userLogin(email!!, password!!)
        authListener?.onSuccess(loginResponse)
    }
}