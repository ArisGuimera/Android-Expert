package com.aristidevs.androidmaster.imcapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.aristidevs.androidmaster.R

class ImcActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc)
        val etHeight = findViewById<EditText>(R.id.etHeight)
        val etWeight = findViewById<EditText>(R.id.etWeight)
        val btnCalculate = findViewById<Button>(R.id.btnCalculate)
        btnCalculate.setOnClickListener {
            val imc = getIMC(etHeight.text.toString().toDouble()/100, etWeight.text.toString().toDouble())
            navigateToResult(imc)
        }
    }

    private fun getIMC(height:Double, weight:Double):Double{
        return weight/(height * height)
    }

    private fun navigateToResult(imc:Double) {
        val intent = Intent(this, ImcResultActivity::class.java)
        intent.putExtra("IMC_RESULT",imc)
        startActivity(intent)
    }
}