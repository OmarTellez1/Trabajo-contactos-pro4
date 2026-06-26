package com.example.tallercontactos

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tallercontactos.actividades.DetalleActivity
import com.example.tallercontactos.adaptadores.ContactoAdapter
import com.example.tallercontactos.entidad.Contacto

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        var main = findViewById<RecyclerView>(R.id.main)
        var listaContactos = listOf<Contacto>(
            Contacto("Carlos","09392032", "carlos@gmail.com", "Sauces"),
            Contacto("Omar","093920332312", "omar@gmail.com", "Villa club"),
            Contacto("Christianna","09392044532", "christianna@gmail.com", "washington"),
            Contacto("Antonio","0922392032", "antonio@gmail.com", "la aurora"),
            Contacto("Jesus","09211122392032", "jesus@gmail.com", "villa del rey")
        )
        var adaptador = ContactoAdapter(listaContactos, {
            var intento = Intent(this, DetalleActivity::class.java)
            intento.putExtra("p-nombre", it.nombre)
            intento.putExtra("p-correo", it.correo)
            intento.putExtra("p-telefono", it.telefono)
            intento.putExtra("p-direccion", it.direccion)
            startActivity(intento)
        })
        main.adapter = adaptador
        main.layoutManager = LinearLayoutManager(this)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}