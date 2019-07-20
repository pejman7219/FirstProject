package com.example.firstproject.Adapter
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.firstproject.DBHelper.MyDbRealm
import com.example.firstproject.Object.DoctorObject
import com.example.firstproject.Object.realmObject
import com.example.firstproject.R




class AdapterFavorite(var user : ArrayList<DoctorObject>):RecyclerView.Adapter<AdapterFavorite.ViewHolder>() {


    lateinit var mcontext : Context


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view : View = LayoutInflater.from(parent.context).inflate(R.layout.sipmel_favorite,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return user.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.name.text = user[position].name

    }

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)
    {

        var name = itemView.findViewById<TextView>(R.id.textnamefavorite)

    }
}