package com.example.tallercontactos.adaptadores

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tallercontactos.R
import com.example.tallercontactos.entidad.Contacto

class ContactoAdapter(var datos: List<Contacto>): RecyclerView.Adapter<ContactoAdapter.ContactoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactoViewHolder {
        val vista = LayoutInflater.from(parent.context).inflate(R.layout.item_contacto, parent, false)
        return ContactoViewHolder(vista)
    }

    override fun onBindViewHolder(holder: ContactoViewHolder, position: Int) {
        var contacto = datos[position]
        holder.txtNombre.setText(contacto.nombre)
        holder.txtDireccion.setText(contacto.direccion)
    }

    override fun getItemCount(): Int {
        return datos.size
    }

    class ContactoViewHolder(vista: View): RecyclerView.ViewHolder(vista){
        private var contenedor: View
        private var nombre: TextView
        private var direccion: TextView
        init{
            contenedor = vista
            nombre = vista.findViewById(R.id.txtNombre)
            direccion = vista.findViewById(R.id.txtDireccion)
        }
    }


}