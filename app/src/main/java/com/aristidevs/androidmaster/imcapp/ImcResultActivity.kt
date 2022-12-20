package com.aristidevs.androidmaster.imcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.aristidevs.androidmaster.R

class ImcResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc_result)
        val imc: Double = intent.extras?.getDouble("IMC_RESULT") ?: -1.0
        val tvResult = findViewById<TextView>(R.id.tvResult)

        tvResult.text = when(imc){
            in 0.0..18.5 -> "Bajo peso"
            in 18.6..24.9 -> "Normal"
            in 25.0..29.9 -> "Sobrepeso"
            in 30.0..99.0 -> "Obesidad"
            else -> "Error"
        }
    }
}