package app.bo.com.ucb.cleanarchitecture2022

import android.app.Application

class AndroidApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initDI()
    }
}