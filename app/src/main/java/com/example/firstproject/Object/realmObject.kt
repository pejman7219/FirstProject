package com.example.firstproject.Object

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass

@RealmClass
open class realmObject : RealmObject() {

        @PrimaryKey
        var id : Int = 0
        var name : String? = null

}