package com.example.firstproject.Application

import android.app.Application
import io.realm.Realm
import io.realm.RealmConfiguration

class G : Application() {
    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
        var config = RealmConfiguration.Builder().name(Realm.DEFAULT_REALM_NAME).build()
        Realm.setDefaultConfiguration(config)
    }
}