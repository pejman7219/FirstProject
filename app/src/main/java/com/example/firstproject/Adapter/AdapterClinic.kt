package com.example.firstproject.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.firstproject.DBHelper.MyDbRealm
import com.example.firstproject.Object.ClinicObject
import com.example.firstproject.Object.DoctorObject
import com.example.firstproject.R

class AdapterClinic(var clinicadres : ArrayList<ClinicObject>): RecyclerView.Adapter<AdapterClinic.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view : View = LayoutInflater.from(parent.context).inflate(R.layout.simpel_clinic,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {

        return clinicadres.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.address.text = clinicadres[position].address
        holder.mcc.text = clinicadres[position].mcc

        holder.clinic.setOnClickListener {


            var us = ClinicObject()

            us.address = clinicadres[position].address
//            us.mcc = clinicadres[position].mcc

            MyDbRealm().saveDataClinic(us)


        }

    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)


    {

        var address = itemView.findViewById<TextView>(R.id.textaddress)
        var mcc = itemView.findViewById<TextView>(R.id.textmcc)
        var clinic = itemView.findViewById<ImageButton>(R.id.btnstarclinic)

    }
}