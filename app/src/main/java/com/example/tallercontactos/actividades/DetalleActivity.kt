package com.example.tallercontactos.actividades

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tallercontactos.R

class DetalleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detalle)
        var txtNombre = findViewById<TextView>(R.id.txtNombre)
        var txtTelefono = findViewById<TextView>(R.id.txtTelefono)
        var txtCorreo = findViewById<TextView>(R.id.txtCorreo)
        var txtDireccion = findViewById<TextView>(R.id.txtDireccion)
        txtNombre.setText(intent.getStringExtra("p-nombre"))
        txtTelefono.setText(intent.getStringExtra("p-telefono"))
        txtCorreo.setText(intent.getStringExtra("p-correo"))
        txtDireccion.setText(intent.getStringExtra("p-direccion"))
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}