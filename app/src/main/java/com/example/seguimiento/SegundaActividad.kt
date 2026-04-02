package com.example.seguimiento

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity

class SegundaActividad : AppCompatActivity() {

    private val TIMER_RUNTIME = 10000
    private var nbActivo = false
    private lateinit var nProgressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_segunda_actividad)

        nProgressBar = findViewById(R.id.progressBar)
        val destino = intent.getStringExtra("destino")

        val timerThread = object : Thread() {
            override fun run() {
                nbActivo = true
                try {
                    var espera1 = 0
                    while (nbActivo && espera1 < TIMER_RUNTIME) {
                        sleep(200)
                        if (nbActivo) {
                            espera1 += 200
                            actualizarProgress(espera1)
                        }
                    }
                } catch (e: InterruptedException) {
                } finally {
                    onContinuar()
                }
            }
        }

        timerThread.start()
    }

    fun actualizarProgress(timePassed: Int) {
        if (::nProgressBar.isInitialized) {
            val progress = nProgressBar.max * timePassed / TIMER_RUNTIME
            nProgressBar.progress = progress
        }
    }

    fun onContinuar() {
        runOnUiThread {
            Log.d("Ciclo de Vida", "Carga completa")

            val destino = intent.getStringExtra("destino")

            if (destino != null) {
                val intent = Intent(this, Class.forName(destino))
                startActivity(intent)
            }
        }
    }

}
