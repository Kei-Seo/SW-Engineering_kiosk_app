package com.example.locationtracking

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_select_menu.*

class SelectMenuActivity : AppCompatActivity() {

    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_menu)


        btn_location_confirm.setOnClickListener{
            var intent : Intent = Intent(this, MapsActivity::class.java)
            startActivity(intent)
        }

        btn_location_register.setOnClickListener{
            database = Firebase.database.reference

            val database = Firebase.database
            val myRef = database.getReference("message")

            myRef.setValue("Hello world")
        }

        btn_back_login.setOnClickListener{
            var intent : Intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)

        }

    }
}