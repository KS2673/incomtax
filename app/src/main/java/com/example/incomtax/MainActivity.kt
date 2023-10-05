package com.example.incomtax

import android.R
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var b1:Button
    private lateinit var b2:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.incomtax.R.layout.activity_main)
        b1 = findViewById(com.example.incomtax.R.id.button1)
        b2 = findViewById(com.example.incomtax.R.id.button2)
        b1.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@MainActivity, Incometax::class.java)
            startActivity(intent)
        })
        b2.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@MainActivity,Emi::class.java)
            startActivity(intent)
        })
    }
}