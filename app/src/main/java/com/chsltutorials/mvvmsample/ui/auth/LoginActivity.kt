package com.chsltutorials.mvvmsample.ui.auth

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.chsltutorials.mvvmsample.R
import com.chsltutorials.mvvmsample.databinding.ActivityLoginBinding
import com.chsltutorials.mvvmsample.util.hide
import com.chsltutorials.mvvmsample.util.show
import com.chsltutorials.mvvmsample.util.toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), AuthListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding : ActivityLoginBinding = DataBindingUtil.setContentView(this,R.layout.activity_login)
        val viewModel = ViewModelProviders.of(this).get(AuthViewModel::class.java)
        binding.viewmodel = viewModel
        viewModel.authListener = this
    }

    override fun onStarted() = progressBar.show()
    override fun onFailure(errorMessage : String) {
        progressBar.hide()
        toast(errorMessage)
    }

    override fun onSuccess(loginResponse: LiveData<String>) {
       progressBar.hide()
       loginResponse.observe(this, Observer {
           toast(it)
       })
    }
}
