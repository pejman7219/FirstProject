package com.example.firstproject.Fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.DefaultRetryPolicy
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.firstproject.Adapter.AdapterClinic
import com.example.firstproject.Application.GetParams
import com.example.firstproject.Object.ClinicObject
import com.example.firstproject.Object.DoctorObject
import com.example.firstproject.R
import kotlinx.android.synthetic.main.fragment_clinik.*
import org.json.JSONException
import org.json.JSONObject

class FragmentClinic : Fragment() {

    var clirec = recyClinic


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var clinikPage = inflater.inflate(R.layout.fragment_clinik,container,false)

        getdata(clinikPage)
        return clinikPage
    }

    fun getdata(clinic : View): ArrayList<DoctorObject>
    {
        val url = "http://ario-dev.ir/application/vaghteto/webservice/api/clinic/list"
        val params = HashMap<String,String>()
        var user = ArrayList<DoctorObject>()
        params.put("skip","0")
        params.put("take", GetParams().take.toString())

        var response = Response.Listener<String> {

            var cliuser = DoctorParser(it)

            clirec = clinic.findViewById(R.id.recyClinic) as RecyclerView
            clirec.layoutManager = LinearLayoutManager(activity)
            clirec.adapter = AdapterClinic(cliuser)
        }
        var error = Response.ErrorListener {

        }
        resApi(url,params,response,error)

        return user
    }

    fun resApi(url : String,params:HashMap<String,String>,response: Response.Listener<String>,error:Response.ErrorListener)
    {
        var strRequest = object : StringRequest(Request.Method.POST,url,response,error)
        {
            override fun getParams(): MutableMap<String, String> {
                return params
            }
        }
        try {
            var queue = Volley.newRequestQueue(activity)
            strRequest.retryPolicy = DefaultRetryPolicy(
                10000,0,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT)
            queue.add(strRequest)

        }catch (e : JSONException)
        {

        }
    }

    fun DoctorParser(response : String):ArrayList<ClinicObject>
    {
        var result = ArrayList<ClinicObject>()
        var jsonob = JSONObject(response)
        var dataJs = jsonob.optString("status")

        if (dataJs == "ok")
        {
            var doctorarray = jsonob.getJSONArray("data")
            for (i in 0 until doctorarray.length()){
                var docobj = ClinicObject().clinParser(doctorarray.getJSONObject(i))
                result.add(docobj)
            }

        }
        return result

    }
}