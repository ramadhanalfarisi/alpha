package com.example.hospirun

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.list_rumahsakit.view.*

class RumahSakitAdapter(val items: MutableList<Model.RumahSakit>, val context: Context):
    RecyclerView.Adapter<RumahSakitAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_rumahsakit,parent,false);
        return ViewHolder(view);
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items.get(position))
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        fun bind(get: Model.RumahSakit){
            itemView.nama.text = get.rumahSakit
            itemView.alamat.text = get.alamat
            itemView.jadwal.text = get.jadwal
            Picasso.get().load(get.gambar).into(itemView.image)

            itemView.setOnClickListener {
                val nama = get.rumahSakit
                val alamat = get.alamat
                val jadwal = get.jadwal
                val telp = get.telp
                val gambar = get.gambar

                val intent = Intent(it.context,DetailRumahSakit::class.java)
                intent.putExtra("nama",nama)
                intent.putExtra("alamat", alamat)
                intent.putExtra("jadwal", jadwal)
                intent.putExtra("telp",telp)
                intent.putExtra("gambar", gambar)
                it.context.startActivity(intent)

            }
        }

    }
}