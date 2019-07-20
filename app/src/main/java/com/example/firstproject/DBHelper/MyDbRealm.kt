package com.example.firstproject.DBHelper

import android.content.Context
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import com.example.firstproject.Object.ClinicObject
import com.example.firstproject.Object.DoctorObject
import com.example.firstproject.Object.realmObject
import io.realm.Realm
import io.realm.RealmResults

class MyDbRealm {

    lateinit var context: Context
    lateinit var realm : Realm
    init {
        realm = Realm.getDefaultInstance()
    }

    fun saveDataDoctor(user : DoctorObject){

        realm.executeTransactionAsync({ realm ->
            val number = realm.where(DoctorObject::class.java).count() +1
            val users = realm.createObject(DoctorObject::class.java!!, number)

            users.name = user.name
            Log.i("Pejman",user.toString())
        },

            {  },
//            { error -> Toast.makeText(context, error.message, Toast.LENGTH_SHORT).show() }
            {

            }
        )

    }

    fun  find1() {
        var user : ArrayList<realmObject> = ArrayList()
        var result : RealmResults<realmObject> = realm.where(realmObject::class.java).findAll()

        for (us in result)
        {
            user.add(us)

        }

    }

    fun saveDataClinic(user : ClinicObject){

        var clinic = ArrayList<ClinicObject>()
        realm.executeTransactionAsync({ realm ->
            val number = realm.where(ClinicObject::class.java).count() +1
            val users = realm.createObject(ClinicObject::class.java!!, number)

            users.address = user.address
//            users.mcc = mcc.mcc
            Log.i("Pejman",users.toString())
        },

            {  },
//            { error -> Toast.makeText(context, error.message, Toast.LENGTH_SHORT).show() }
            {

            }
        )


    }
    fun readToRealm():ArrayList<DoctorObject>
    {
        val docteruser = ArrayList<DoctorObject>()
        var alldata = realm.where(DoctorObject::class.java).findAll()

        var data : String? = ""
        for (i in alldata)
        {

//            var name  = alldata.get(i)!!.name
            docteruser.add(i)



//            data =  data + "$name \n"


        }
        return docteruser

    }

    fun readToRealmClinic():ArrayList<ClinicObject> {
        val docteruser = ArrayList<ClinicObject>()
        var alldata = realm.where(ClinicObject::class.java).findAll()

        for (i in alldata) {
            docteruser.add(i)
        }
        return docteruser
    }

}
