package com.example.tallercontactos

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
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
            Contacto("Antonio","0922392032", "antonio@gmail.com", "la aurora")
        )
        var adaptador = ContactoAdapter(listaContactos)
        main.adapter = adaptador
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}