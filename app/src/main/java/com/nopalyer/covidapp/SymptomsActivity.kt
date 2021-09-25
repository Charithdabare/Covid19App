package com.nopalyer.covidapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_symptoms.*

class SymptomsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_symptoms)

        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL,false)
        val symptomsList = ArrayList<Model>()
        symptomsList.add(Model(R.drawable.cough,"Dry Cough","This cough has a consistent tone because it is free from the sound of mucus.it is caused by irritation and inflammation of the airway."))
        symptomsList.add(Model(R.drawable.fever,"Fever","If there is persistent fever, covid 19 may form."))
        symptomsList.add(Model(R.drawable.pain,"Head Ache","A headache is early and late in the infection phase, with a later headache possibly being associated with covid 19."))
        symptomsList.add(Model(R.drawable.sore_throat,"Sore Throat","5-10%of COVID patients will have this.Usually,they will have a touch of fever,loss of taste and smell and difficulty breathing."))

        val symptomsAdapter = SymptomsAdapter(symptomsList)

        recyclerView.adapter = symptomsAdapter
    }
}
