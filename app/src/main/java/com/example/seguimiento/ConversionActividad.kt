package com.example.seguimiento

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ConversionActividad : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_conversion)

        val monto = findViewById<EditText>(R.id.etMonto)
        val btn = findViewById<Button>(R.id.btnConvertir)
        val resultado = findViewById<TextView>(R.id.tvResultado)

        btn.setOnClickListener {
            val soles = monto.text.toString().toDoubleOrNull()

            if (soles != null) {
                val dolares = soles / 3.8
                resultado.text = "USD: $dolares"
            } else {
                resultado.text = "Ingrese un valor válido"
            }
        }
    }
}
