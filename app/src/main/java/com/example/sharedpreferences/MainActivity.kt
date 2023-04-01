package com.example.sharedpreferences

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    var campoUsuario:EditText?=null
    var campoPass:EditText?=null
    var txtUsuario:TextView?=null
    var txtPass:TextView?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        iniciarComponentes()
        cargarDatos()

    }

    private fun iniciarComponentes() {
        var btnGuardar:Button=findViewById(R.id.btnGuardar)
        btnGuardar.setOnClickListener { guardarDatos() }

        var btnCargar:Button=findViewById(R.id.btnCargar)
        btnCargar.setOnClickListener { cargarDatos() }

        campoUsuario=findViewById(R.id.campoUser)
        campoPass=findViewById(R.id.campoPass)
        txtUsuario=findViewById(R.id.txtUsuario)
        txtPass=findViewById(R.id.txtPass)
    }

    private fun guardarDatos() {
        //creamos las preferencias
        var preferences:SharedPreferences=getSharedPreferences("credenciales",Context.MODE_PRIVATE)

        var usuario= campoUsuario?.text.toString()
        var pass= campoPass?.text.toString()

        //decimos que vamos a editar el archivo
        var editor:SharedPreferences.Editor=preferences.edit()
        editor.putString("user",usuario)
        editor.putString("pass",pass)

        txtUsuario?.text=usuario
        txtPass?.text=pass

        //confirmamos el almacenamiento
        editor.commit()

        Toast.makeText(this,"Se han registrado los datos",Toast.LENGTH_SHORT).show()
    }

    private fun cargarDatos() {
        //Abrimos el archivo de preferencias
        var preferences:SharedPreferences=getSharedPreferences("credenciales",Context.MODE_PRIVATE)

        //Se cargan los valores del archivo de preferencias
        var user: String? =preferences.getString("user","No existe la información")
        var pass: String? =preferences.getString("pass","No existe la información")

        val intent = Intent(this, MainActivity2::class.java)
        val content: Bundle = Bundle()
        content.putString("user", user)
        content.putString("pass", pass)
        intent.putExtras(content)
        startActivity(intent)

    }

}