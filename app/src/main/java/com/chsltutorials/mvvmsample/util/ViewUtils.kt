package com.chsltutorials.mvvmsample.util

import android.content.Context
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.view.*

fun Context.toast(message : String){
    Toast.makeText(this, message,Toast.LENGTH_LONG).show()
}

fun ProgressBar.show(){
    progressBar.visibility = View.VISIBLE
}

fun ProgressBar.hide(){
    progressBar.visibility = View.GONE
}