package com.example.hospirun

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detail_rujukan.*

class DetailRujukan : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_rujukan)

        val intent = intent
        val Mnama = intent.getStringExtra("nama").toString()
        val Malamat = intent.getStringExtra("alamat").toString()
        val Mjadwal = intent.getStringExtra("jadwal").toString()
        val Mtelp = intent.getStringExtra("telp").toString()

        nama.text = Mnama
        alamat.text = Malamat
        jadwal.text = Mjadwal
        telp.text = Mtelp
    }
}
