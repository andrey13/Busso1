package com.raywenderlich.android.busso

import android.app.Application
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.raywenderlich.android.busso.di.ServiceLocator
import com.raywenderlich.android.busso.di.ServiceLocatorImpl

class Main : Application() {
    init {
        mylog("-------------------------------------------------------------START")
    }

    lateinit var serviceLocator: ServiceLocator

    override fun onCreate() {
        super.onCreate()
        serviceLocator = ServiceLocatorImpl(this)
    }
}

internal fun <A : Any> AppCompatActivity.lookUp(name: String): A {
    mylog("CALL AppCompatActivity.lookUp ---------------> ")
    mylog("    applicationContext = ${applicationContext as Main},  this = $this")
    return (applicationContext as Main).serviceLocator.lookUp(name)
}

fun mylog(s: String) {
    Log.i("--==>", s)
}