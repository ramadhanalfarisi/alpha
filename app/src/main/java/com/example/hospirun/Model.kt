package com.example.hospirun

import java.lang.reflect.Constructor

object Model {
    data class RumahSakit(
        val rumahSakit: String,
        val alamat: String,
        val jadwal: String,
        val telp: String,
        val gambar: String
    ){
        constructor():this("","","","","")
    }

    data class Rujukan(
        val nama: String,
        val alamat: String,
        val jadwal: String,
        val telp: String
    ){
        constructor():this("","","","")
    }

    class Solusi(
        val nama: String,
        val penyebab: String,
        val gejala: String,
        val solusi: String
    ){
        constructor():this("","","","")
    }
}