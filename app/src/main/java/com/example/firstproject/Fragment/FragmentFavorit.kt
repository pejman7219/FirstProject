package com.example.firstproject.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firstproject.Adapter.AdapterAddress
import com.example.firstproject.Adapter.AdapterClinic
import com.example.firstproject.Adapter.AdapterFavorite
import com.example.firstproject.DBHelper.MyDbRealm
import com.example.firstproject.Object.ClinicObject
import com.example.firstproject.Object.DoctorObject
import com.example.firstproject.R
import kotlinx.android.synthetic.main.fragment_favorit.*
import java.util.zip.Inflater

class FragmentFavorit : Fragment() {
//    init {
//        var context : Context
//    }
    var recy = rec1
    var recy2 = rec2
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var favoritPage = inflater.inflate(R.layout.fragment_favorit,container,false)

//        viewpagerFavorit.adapter = AdabterTabbar()
        var docuser = ArrayList<DoctorObject>()
        var data = MyDbRealm()
        docuser = data.readToRealm()

        recy = favoritPage.findViewById(R.id.rec1)
        recy.layoutManager = LinearLayoutManager(activity)
        recy.adapter = AdapterFavorite(docuser)

        var clinic = ArrayList<ClinicObject>()

        clinic = data.readToRealmClinic()
        recy2 = favoritPage.findViewById(R.id.rec2)
        recy2.layoutManager = LinearLayoutManager(activity)
        recy2.adapter = AdapterAddress(clinic)
        return favoritPage

    }

    override fun onResume() {
        super.onResume()
        var docuser = ArrayList<DoctorObject>()
        var data = MyDbRealm()
        docuser = data.readToRealm()


        recy = view!!.findViewById(R.id.rec1)
        recy.layoutManager = LinearLayoutManager(activity)
        recy.adapter = AdapterFavorite(docuser)

        var clinic = ArrayList<ClinicObject>()

        clinic = data.readToRealmClinic()
        recy2 = view!!.findViewById(R.id.rec2)
        recy2.layoutManager = LinearLayoutManager(activity)
        recy2.adapter = AdapterAddress(clinic)
    }
}