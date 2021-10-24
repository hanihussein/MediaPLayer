package com.hani.mediaplayer

import android.app.Application
import javax.net.ssl.HttpsURLConnection

class Application : Application() {


    override fun onCreate() {
        super.onCreate()

        HttpsURLConnection.setDefaultSSLSocketFactory(MyCustomSSLSocketFactory())

    }
}