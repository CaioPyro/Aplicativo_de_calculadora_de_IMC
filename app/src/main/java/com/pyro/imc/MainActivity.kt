package com.pyro.imc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
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

            if (tbxPeso.text.toString() != "" && tbxAltura.text.toString() != ""){
                val imc:Float = peso.toString().toFloat() / (altura.toString().toFloat() * altura.toString().toFloat())
                val intent = Intent(this,SecondActivity::class.java)
                intent.putExtra(eXTRA_NUMBER,imc)
                startActivity(intent)
            }else this.showToast(message = "Preencha todos os campos!")
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show()
    }
}