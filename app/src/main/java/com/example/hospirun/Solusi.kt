package com.example.hospirun

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_solusi.*

class Solusi : AppCompatActivity() {

    val penyakit: ArrayList<Model.Solusi> = ArrayList()
    lateinit var reference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_solusi)

        val linear = LinearLayoutManager(this)
        recycler.layoutManager = linear
        recycler.setHasFixedSize(true)
        recycler.adapter = SolusiAdapter(penyakit, this)

        reference = FirebaseDatabase.getInstance().getReference("solusi")
        fill()

    }

    private fun fill() {

        reference.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {

            }

            override fun onDataChange(p0: DataSnapshot) {
                if (p0.exists()) {
                   penyakit.clear()
                    for(i in p0.children){
                        val solusi = i.getValue(Model.Solusi::class.java)
                        penyakit.add(solusi!!)
                    }
                    val adapter = SolusiAdapter(penyakit,applicationContext)
                    recycler.adapter = adapter
                }
            }

        })

    }
}
