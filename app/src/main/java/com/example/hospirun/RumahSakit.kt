package com.example.hospirun

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_rumah_sakit.*

class RumahSakit : AppCompatActivity() {

    val items: ArrayList<Model.RumahSakit> = ArrayList()
    lateinit var reference: DatabaseReference;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rumah_sakit)

        val linearLayoutManager = LinearLayoutManager(this);
        recycler.layoutManager = linearLayoutManager
        recycler.setHasFixedSize(true)
        recycler.adapter = RumahSakitAdapter(items, this)

        reference = FirebaseDatabase.getInstance().getReference("rumahsakit")

        fill();


    }

    private fun fill(){

        reference.addValueEventListener(object: ValueEventListener{
            override fun onCancelled(p0: DatabaseError) {

            }

            override fun onDataChange(p0: DataSnapshot) {
                if(p0.exists()){
                    items.clear()
                    for(i in p0.children){
                        val rumahsakit = i.getValue(Model.RumahSakit::class.java)
                        items.add(rumahsakit!!)
                    }

                    val adapter = RumahSakitAdapter(items,applicationContext)
                    recycler.adapter = adapter
                }
            }

        })

    }
}
