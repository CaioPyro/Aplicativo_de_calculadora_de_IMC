package com.pyro.imc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import java.math.BigDecimal
import java.util.*

class MainActivity : AppCompatActivity() {
    companion object{
        const val eXTRA_NUMBER: String = "com.example.application.example.eXTRA_NUMBER"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.elevation = 0F

        val peso = tbxPeso.text
        val altura = tbxAltura.text
        val calcular = findViewById<Button>(R.id.btnCalcular)

        calcular.setOnClickListener() {

            if (peso != null && altura != null){
                val imc:Float = peso.toString().toFloat() / (altura.toString().toFloat() * altura.toString().toFloat())
                val intent = Intent(this,SecondActivity::class.java)
                intent.putExtra(eXTRA_NUMBER,imc)
                startActivity(intent)
            }

            if ((peso.toString() == null) && (altura.toString() == "")){
                text.text = "Insira os dados"
            }
        }
    }
}