package com.pyro.imc

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.pyro.imc.MainActivity.Companion.eXTRA_NUMBER
import kotlinx.android.synthetic.main.activity_second.*
import androidx.appcompat.app.ActionBar

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.elevation = 0F

        val intent: Intent = intent
        var imc: Float = intent.getFloatExtra(eXTRA_NUMBER,0F)

        val text = findViewById<TextView>(R.id.resPeso)

        text.setText("Seu IMC é de "+imc.toString())

        if(imc < 18.5){resTexto.text = "Classificação: \nAbaixo do peso"}
        if(imc in 18.5..24.9){resTexto.text = "Classificação: \nPeso normal"}
        if(imc in 25.0..29.9){resTexto.text = "Classificação: \nSobrepeso"}
        if(imc in 30.0..34.9){resTexto.text = "Classificação: \nObesidade de grau I"}
        if(imc in 35.0..39.9){resTexto.text = "Classificação: \nObesidade de grau II"}
        if(imc >= 40){resTexto.text = "Classificação: \nObesidade de grau III"}
    }
}