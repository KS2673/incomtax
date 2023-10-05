package com.example.incomtax

import android.R
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Incometax : AppCompatActivity() {
    var et: EditText? = null
    var tx: TextView? = null
    var tx1: TextView? = null
    var b1: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.incomtax.R.layout.activity_incometax)
        et = findViewById<EditText>(com.example.incomtax.R.id.edit1)
        tx = findViewById(com.example.incomtax.R.id.text1)
        tx1 = findViewById(com.example.incomtax.R.id.text2)
        b1 = findViewById(com.example.incomtax.R.id.button3)
        b1!!.setOnClickListener(View.OnClickListener {
            try {
                et!!.getText().toString().toInt()
                calculate()
            } catch (e: Exception) {
                Toast.makeText(
                    applicationContext,
                    "You have exceeded the Input Limit!",
                    Toast.LENGTH_LONG
                ).show()
                tx1!!.setText("")
            }
        })
    }

    @SuppressLint("SetTextI18n")
    fun calculate() {
        var Total: Long = 0
        var Tax: Long = 0
        val `in` = et!!.text.toString().toInt().toLong()
        if (`in` >= 200000 && `in` < 1000000) {
            Tax = `in` * 5 / 100
            Total = `in` + Tax
        } else if (`in` >= 1000000 && `in` < 2000000) {
            Tax = `in` * 10 / 100
            Total = `in` + Tax
        } else if (`in` >= 2000000 && `in` < 3000000) {
            Tax = `in` * 15 / 100
            Total = `in` + Tax
        } else if (`in` >= 3000000 && `in` < 4000000) {
            Tax = `in` * 20 / 100
            Total = `in` + Tax
        } else if (`in` >= 4000000 && `in` < 5000000) {
            Tax = `in` * 25 / 100
            Total = `in` + Tax
        } else if (`in` >= 5000000 && `in` < 7000000) {
            Tax = `in` * 30 / 100
            Total = `in` + Tax
        } else if (`in` >= 7000000 && `in` < 10000000) {
            Tax = `in` * 35 / 100
            Total = `in` + Tax
        } else if (`in` >= 10000000) {
            Tax = `in` * 40 / 100
            Total = `in` + Tax
        }
        tx1!!.text = """Tax on your income ${et!!.text}= 	$Tax
 
Total Income (Inclusion of Tax) = 	$Total"""
    }
}