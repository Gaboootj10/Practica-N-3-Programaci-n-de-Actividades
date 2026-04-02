package com.example.seguimiento

import android.content.Intent
import android.widget.Button
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import androidx.core.content.ContextCompat.startActivity


class MainActivity : AppCompatActivity() {

    private val TAG = "Ciclo de Vida"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main);

        Log.d(TAG, "En el evento onCreate()")

        val boton = findViewById<Button>(R.id.btnMostrar)
        val btnConversion = findViewById<Button>(R.id.btnConversion)
        val btnDrawer = findViewById<Button>(R.id.btnDrawer)

        btnConversion.setOnClickListener {
            val intent = Intent(this, SegundaActividad::class.java)
            intent.putExtra("destino", ConversionActividad::class.java.name)
            startActivity(intent)
        }

        btnDrawer.setOnClickListener {
            val intent = Intent(this, SegundaActividad::class.java)
            intent.putExtra("destino", DrawerActivity::class.java.name)
            startActivity(intent)
        }

        boton.setOnClickListener {
            val intent = Intent(this, SegundaActividad::class.java)
            startActivity(intent)
        }

    }

    fun onClick(view: View) {
        val intent = Intent(this, SegundaActividad::class.java)
        startActivity(intent)
    }
    override fun onStart(){
        super.onStart();
        Log.d(TAG, "En el evento onStart()")
    }

    override fun onRestart(){
        super.onRestart();
        Log.d(TAG, "En el evento onRestart()")
    }

    override fun onResume() {
        super.onResume();
        Log.d(TAG, "En el evento onResume()")
    }

    override fun onPause()  {
        super.onPause();
        Log.d(TAG, "En el evento onPause()")
    }

    override fun onStop()   {
        super.onStop();
        Log.d(TAG, "En el evento onStop()")
    }

    override fun onDestroy(){
        super.onDestroy();
        Log.d(TAG, "En el evento onDestroy()")
    }


}

