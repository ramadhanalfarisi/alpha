package com.example.hospirun

import android.content.Context
import android.content.Intent
import android.view.Display
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_solusi.view.*

class SolusiAdapter(val items: MutableList<Model.Solusi>, val context: Context):
    RecyclerView.Adapter<SolusiAdapter.ViewHolder>() {
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        fun bind(get : Model.Solusi){
            itemView.penyakit.text = get.nama
            itemView.deskripsi.text = get.penyebab

            itemView.setOnClickListener {
                val nama = get.nama
                val penyebab = get.penyebab
                val gejala = get.gejala
                val solusi = get.solusi

                val intent = Intent(it.context,DetailSolusi::class.java)
                intent.putExtra("penyakit",nama)
                intent.putExtra("penyebab", penyebab)
                intent.putExtra("gejala", gejala)
                intent.putExtra("solusi",solusi)
                it.context.startActivity(intent)

            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SolusiAdapter.ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_solusi,parent,false)
        return ViewHolder(view);
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: SolusiAdapter.ViewHolder, position: Int) {
        holder.bind(items.get(position))
    }
}