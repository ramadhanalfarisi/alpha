package com.example.hospirun

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail_rumah_sakit.*

class DetailRumahSakit : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_rumah_sakit)

        val intent = intent
        val Mnama = intent.getStringExtra("nama").toString()
        val Malamat = intent.getStringExtra("alamat").toString()
        val Mjadwal = intent.getStringExtra("jadwal").toString()
        val Mtelp = intent.getStringExtra("telp").toString()
        val gambar = intent.getStringExtra("gambar").toString()

        rumahsakit.text = Mnama
        alamat.text = Malamat
        jadwal.text = Mjadwal
        telp.text = Mtelp
        Picasso.get().load(gambar).placeholder(R.mipmap.ic_launcher_round).into(image)

        map.setOnClickListener {
            map()
        }

    }

    fun map(){
        val cari  = rumahsakit.text.toString()
        val uri = Uri.parse("geo:0,0?q=" + cari)
        val intent = Intent(Intent.ACTION_VIEW,uri)
        if(intent.resolveActivity(packageManager) != null){
            startActivity(intent)
        }else{
            Toast.makeText(this,"Raiso",Toast.LENGTH_SHORT).show()
        }
    }
}
