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

class AdapterAddress(var clinicadres : ArrayList<ClinicObject>): RecyclerView.Adapter<AdapterAddress.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view : View = LayoutInflater.from(parent.context).inflate(R.layout.simpel_address,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {

        return clinicadres.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.address.text = clinicadres[position].address


    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)


    {

        var address = itemView.findViewById<TextView>(R.id.txtaddress)


    }
}