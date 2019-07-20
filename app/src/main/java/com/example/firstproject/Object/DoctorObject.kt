package com.example.firstproject.Object

import com.android.volley.toolbox.JsonObjectRequest
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass
import org.json.JSONObject
@RealmClass
open class DoctorObject : RealmObject() {
    @PrimaryKey
    var id:Int = 0
    var name:String? = null

    fun dataParser(data : JSONObject):DoctorObject
    {
        id = data.optInt("id")
        name = data.optString("name")
        return this

    }
}