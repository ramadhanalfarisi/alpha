package com.example.hospirun

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_rujukan.view.*

class RujukanAdapter(val list:MutableList<Model.Rujukan>, val context: Context):
    RecyclerView.Adapter<RujukanAdapter.ViewHolder>() {
    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

        fun bind(get: Model.Rujukan){
            itemView.nama.text = get.nama
            itemView.alamat.text = get.alamat
            itemView.jadwal.text = get.jadwal
            itemView.setOnClickListener {
                val nama = get.nama
                val alamat = get.alamat
                val jadwal = get.jadwal
                val telp = get.telp

                val intent = Intent(it.context,DetailRujukan::class.java)
                intent.putExtra("nama",nama)
                intent.putExtra("alamat", alamat)
                intent.putExtra("jadwal", jadwal)
                intent.putExtra("telp",telp)
                it.context.startActivity(intent)

            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RujukanAdapter.ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_rujukan,parent,false);
        return ViewHolder(view);
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RujukanAdapter.ViewHolder, position: Int) {
        holder.bind(list.get(position))
    }
}