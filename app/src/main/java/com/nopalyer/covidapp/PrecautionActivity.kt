package com.nopalyer.covidapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_precaution.*

class PrecautionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_precaution)

        recyclerView.layoutManager = LinearLayoutManager(this,LinearLayout.VERTICAL,false)
        val precautionsList = ArrayList<Model>()
        precautionsList.add(Model(R.drawable.soap,"Hand Wash","Please Remember To Wash Your Hands For 20 Seconds With Soap and Water."))
        precautionsList.add(Model(R.drawable.hone,"Stay Home","Stay Home Stay Safe & Save Lives."))
        precautionsList.add(Model(R.drawable.distance,"Social Distance","Stay At Least 2 Metres (6feet) Away From Other People."))
        precautionsList.add(Model(R.drawable.clean,"Clean Object & Surface","Clean and Disinfect Frequently Touched Objects And Surfaces."))
        precautionsList.add(Model(R.drawable.cover,"Avoid Touching","Do Not Touch Your Eyes,Nose and Mouth."))

        val precautionsAdapter = PrecautionsAdapter(precautionsList)

        recyclerView.adapter = precautionsAdapter
    }
}
