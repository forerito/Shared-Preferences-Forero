package com.example.sharedpreferences

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val datosGuardados = findViewById<TextView>(R.id.txtDatos)

        var data: Bundle? = this.intent.extras

        if(data != null) {
            datosGuardados.text = "Usuario: ${data.getString("user")} \n Pass: ${data.getString("pass")}"
        }
        val botonRegresar: Button = findViewById(R.id.botonRegresar)
        botonRegresar.setOnClickListener{onClick()}
    }

    private fun onClick() {
        finish()
    }
}