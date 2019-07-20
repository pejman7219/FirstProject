package com.example.firstproject.Object

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass
import org.json.JSONObject
@RealmClass
open class ClinicObject : RealmObject() {


    @PrimaryKey
    var id : Int = 0
    var address : String? = null
    var mcc : String? = null

    fun clinParser(clinic:JSONObject):ClinicObject
    {
        address = clinic.optString("user_type")
        mcc = clinic.optString("name")

        return this
    }
}