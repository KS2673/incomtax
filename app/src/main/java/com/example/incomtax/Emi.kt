package com.example.incomtax

import android.R
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class Emi : AppCompatActivity() {
    var emiCalcBtn: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.incomtax.R.layout.activity_emi)
        val P = findViewById<EditText>(com.example.incomtax.R.id.principal)
        val I = findViewById<EditText>(com.example.incomtax.R.id.interest)
        val Y = findViewById<EditText>(com.example.incomtax.R.id.years)
        val TI = findViewById<EditText>(com.example.incomtax.R.id.interest_total)
        val result = findViewById<EditText>(com.example.incomtax.R.id.emi)
        emiCalcBtn = findViewById<Button>(com.example.incomtax.R.id.btn_calculate2)
        emiCalcBtn!!.setOnClickListener(View.OnClickListener {
            val st1 = P.text.toString()
            val st2 = I.text.toString()
            val st3 = Y.text.toString()
            if (TextUtils.isEmpty(st1)) {
                P.error = "Enter Principal Amount"
                P.requestFocus()
                return@OnClickListener
            }
            if (TextUtils.isEmpty(st2)) {
                I.error = "Enter Interest Rate"
                I.requestFocus()
                return@OnClickListener
            }
            if (TextUtils.isEmpty(st3)) {
                Y.error = "Enter Years"
                Y.requestFocus()
                return@OnClickListener
            }
            val p = st1.toFloat()
            val i = st2.toFloat()
            val y = st3.toFloat()
            val Principal = calPric(p)
            val Rate = calInt(i)
            val Months = calMonth(y)
            val Dvdnt = calDvdnt(Rate, Months)
            val FD = calFinalDvdnt(Principal, Rate, Dvdnt)
            val D = calDivider(Dvdnt)
            val emi = calEmi(FD, D)
            val TA = calTa(emi, Months)
            val ti = calTotalInt(TA, Principal)
            result.setText(emi.toString())
            TI.setText(ti.toString())
        })
    }

    fun calPric(p: Float): Float {
        return p
    }

    fun calInt(i: Float): Float {
        return i / 12 / 100
    }

    fun calMonth(y: Float): Float {
        return y * 12
    }

    fun calDvdnt(Rate: Float, Months: Float): Float {
        return Math.pow((1 + Rate).toDouble(), Months.toDouble()).toFloat()
    }

    fun calFinalDvdnt(Principal: Float, Rate: Float, Dvdnt: Float): Float {
        return Principal * Rate * Dvdnt
    }

    fun calDivider(Dvdnt: Float): Float {
        return Dvdnt - 1
    }

    fun calEmi(FD: Float, D: Float): Float {
        return FD / D
    }

    fun calTa(emi: Float, Months: Float): Float {
        return emi * Months
    }

    fun calTotalInt(TA: Float, Principal: Float): Float {
        return TA - Principal
    }
}