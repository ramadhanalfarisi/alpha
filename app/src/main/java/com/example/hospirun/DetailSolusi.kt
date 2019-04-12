package com.example.hospirun

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detail_solusi.*

class DetailSolusi : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_solusi)

        val intent = intent
        val Mnama = intent.getStringExtra("penyakit").toString()
        val Malamat = intent.getStringExtra("penyebab").toString()
        val Mjadwal = intent.getStringExtra("gejala").toString()
        val Mtelp = intent.getStringExtra("solusi").toString()

        penyakit.text = Mnama
        penyebab.text = Malamat
        gejala.text = Mjadwal
        solusi.text = Mtelp
    }
}
