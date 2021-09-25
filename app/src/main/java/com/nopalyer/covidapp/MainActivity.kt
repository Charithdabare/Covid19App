package com.nopalyer.covidapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.layoutManager = LinearLayoutManager(this,LinearLayout.HORIZONTAL,false)
        val symptomsList = ArrayList<Model>()
        symptomsList.add(Model(R.drawable.cough,"Dry Cough","This cough has a consistent tone because it is free from the sound of mucus.it is caused by irritation and inflammation of the airway."))
        symptomsList.add(Model(R.drawable.fever,"Fever","If there is persistent fever, covid 19 may form."))
        symptomsList.add(Model(R.drawable.pain,"Head Ache","A headache is early and late in the infection phase, with a later headache possibly being associated with covid 19."))

        val symptomsAdapter = SymptomsAdapter(symptomsList)

        recyclerView.adapter = symptomsAdapter


        recyclerViewPrecautions.layoutManager = LinearLayoutManager(this,LinearLayout.HORIZONTAL,false)
        val precautionsList = ArrayList<Model>()
        precautionsList.add(Model(R.drawable.soap,"Hand Wash","Please Remember To Wash Your Hands For 20 Seconds With Soap and Water."))
        precautionsList.add(Model(R.drawable.hone,"Stay Home","Stay Home Stay Safe & Save Lives."))
        precautionsList.add(Model(R.drawable.distance,"Social Distance","Stay At Least 2 Metres (6feet) Away From Other People."))
     
        val precautionsAdapter = PrecautionsAdapter(precautionsList)

        recyclerViewPrecautions.adapter = precautionsAdapter

        txtViewSymptoms.setOnClickListener {
            var intent = Intent(this@MainActivity,SymptomsActivity::class.java)
            startActivity(intent)
        }

        btnKnowMore.setOnClickListener {
            var intent = Intent(this@MainActivity,KnowMoreActivity::class.java)
            startActivity(intent)
        }

        txtViewPrecautions.setOnClickListener {
            var intent = Intent(this@MainActivity,PrecautionActivity::class.java)
            startActivity(intent)
        }


        getGlobalData()
    }

    fun getGlobalData(){
        val url:String ="https://corona.lmao.ninja/v2/all/"

        val stringRequest = StringRequest(
            Request.Method.GET,
            url,
            Response.Listener<String> {

                var jsonObject = JSONObject(it.toString())

                //now set values in textview
                txtInfected.text = jsonObject.getString("cases")
                txtRecoverd.text = jsonObject.getString("recovered")
                txtDeceased.text = jsonObject.getString("deaths")

            },
            Response.ErrorListener {
                Toast.makeText(this@MainActivity,it.toString(),Toast.LENGTH_LONG).show()
                txtInfected.text = "-"
                txtRecoverd.text = "-"
                txtDeceased.text = "-"

            }
        )

        val requestQueue = Volley.newRequestQueue(this@MainActivity)
        requestQueue.add(stringRequest)
    }

}
