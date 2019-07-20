package com.example.firstproject.Conection

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.DefaultRetryPolicy
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.firstproject.Application.GetParams
import com.example.firstproject.Object.DoctorObject
import org.json.JSONException
import org.json.JSONObject

class MyConection (internal var context: Context){




    fun resApi(url : String,params:HashMap<String,String>,response: Response.Listener<String>,error:Response.ErrorListener)
    {
        var strRequest = object : StringRequest(Request.Method.POST,url,response,error)
        {
            override fun getParams(): MutableMap<String, String> {
                return params
            }
        }
        try {
            var queue = Volley.newRequestQueue(context)
            strRequest.retryPolicy = DefaultRetryPolicy(
                10000,0,
           DefaultRetryPolicy.DEFAULT_BACKOFF_MULT)
            queue.add(strRequest)

        }catch (e : JSONException)
        {

        }
    }

    fun DoctorParser(response : String):ArrayList<DoctorObject>
    {
        var result = ArrayList<DoctorObject>()
        var jsonob = JSONObject(response)
        var dataJs = jsonob.optString("status")

        if (dataJs == "ok")
        {
            var doctorarray = jsonob.getJSONArray("data")
            for (i in 0 until doctorarray.length()){
                var docobj = DoctorObject().dataParser(doctorarray.getJSONObject(i))
                result.add(docobj)
            }

        }
        return result

    }

//    fun getdata(): ArrayList<DoctorObject>
//    {
//        val url = "http://ario-dev.ir/application/vaghteto/webservice/api/doctor/list"
//        val params = HashMap<String,String>()
//        var user = ArrayList<DoctorObject>()
//        params.put("skip","0")
//        params.put("take", GetParams().take.toString())
//
//        var response = Response.Listener<String> {
//
//            var docuser = MyConection(context).DoctorParser(it)
//            docuser.addAll(user)
//
//
//
//        }
//        var error = Response.ErrorListener {
//
//        }
//        MyConection(context).resApi(url,params,response,error)
//
//        return user
//    }
}