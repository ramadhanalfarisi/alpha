package com.example.hospirun

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Display
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_rujukan.*

class Rujukan : AppCompatActivity() {

    val arrayList: ArrayList<Model.Rujukan> = ArrayList()
    lateinit var reference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rujukan)

        val linear = LinearLayoutManager(this)
        recycler.layoutManager = linear
        recycler.adapter = RujukanAdapter(arrayList,this);
        recycler.setHasFixedSize(true);

        reference = FirebaseDatabase.getInstance().getReference("rujukan")

        fill();
    }

    private fun fill() {

        reference.addValueEventListener(object: ValueEventListener{
            override fun onCancelled(p0: DatabaseError) {

            }

            override fun onDataChange(p0: DataSnapshot) {
                if(p0.exists()){
                    arrayList.clear()
                    for(i in p0.children){
                        val rujukan = i.getValue(Model.Rujukan::class.java)
                        arrayList.add(rujukan!!)
                    }
                    val adapter = RujukanAdapter(arrayList,applicationContext)
                    recycler.adapter = adapter
                }
            }

        })

    }
}
