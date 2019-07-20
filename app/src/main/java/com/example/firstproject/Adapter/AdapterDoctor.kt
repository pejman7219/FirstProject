package com.example.firstproject.Adapter
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.firstproject.DBHelper.MyDbRealm
import com.example.firstproject.Object.DoctorObject
import com.example.firstproject.Object.realmObject
import com.example.firstproject.R
import io.realm.Realm


class AdapterDoctor(var user : ArrayList<DoctorObject>):RecyclerView.Adapter<AdapterDoctor.ViewHolder>() {


    lateinit var realm : Realm
    lateinit var context : Context


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view : View = LayoutInflater.from(parent.context).inflate(R.layout.sipmel_doctor,parent,false)
        return ViewHolder(view)
    }
    override fun getItemCount(): Int {
        return user.size
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.id.text = user[position].id.toString()
        holder.name.text = user[position].name

        holder.favorit.setOnClickListener {


            var us = DoctorObject()

            us.name = user[position].name


           MyDbRealm().saveDataDoctor(us)


        }
    }
    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)
    {
        var id = itemView.findViewById<TextView>(R.id.textid)
        var name = itemView.findViewById<TextView>(R.id.textname)
        var favorit = itemView.findViewById<ImageButton>(R.id.btnstar)

    }
    fun saveData(uss : realmObject){


        realm.executeTransactionAsync({ realm ->
            var nextid = realm.where(DoctorObject::class.java).count() +1
            val users = realm.createObject(realmObject::class.java,nextid)
            Log.i("Pejman",users.toString())
            users.name = uss.name
        },
            { Toast.makeText(context, "ذخیره انجام شد", Toast.LENGTH_SHORT).show() },
//            { error -> Toast.makeText(context, error.message, Toast.LENGTH_SHORT).show() }
            {

            }
        )

    }

    fun save(name: String)
    {
        realm = Realm.getDefaultInstance()
        realm.beginTransaction()

        var number = realm.where(DoctorObject::class.java).count() + 1
        var user = realm.createObject(DoctorObject::class.java,number)

        user.name = name
        realm.commitTransaction()
    }

}