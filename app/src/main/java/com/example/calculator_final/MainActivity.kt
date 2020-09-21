package com.example.calculator_final

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception
import java.util.*
import kotlin.math.abs
import kotlin.math.pow
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {

    private var tvExpression: TextView? = null
    private var tvClear: Button? = null
    private var tvOne: Button? = null
    private var tvTwo: Button? = null
    private var tvThree: Button? = null
    private var tvFour: Button? = null
    private var tvFive: Button? = null
    private var tvSix: Button? = null
    private var tvSeven: Button? = null
    private var tvEight: Button? = null
    private var tvNine: Button? = null
    private var tvZero: Button? = null
    private var tvMul: Button? = null
    private var tvDivision: Button? = null
    private var tvPlus: Button? = null
    private var tvMinus: Button? = null
    private var tvDot: Button? = null
    private var tvResult: TextView? = null
    private var tvEq: TextView? = null
    private var tvNegat: Button? = null
    private var tvPower: Button? = null
    private var tvSquare: Button? = null
    private var tvTripl: Button? = null
    private var tvFact: Button? = null
    private var  tvSqrt: Button? = null
    private var tvSin: Button? = null
    private var tvCos: Button? = null
    private var tvTan: Button? = null
    private var  tvCot: Button? = null

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        tvExpression?.text = savedInstanceState.getString("expression")
        tvResult?.text = savedInstanceState.getString("result")

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("expression", tvExpression?.text.toString())
        outState.putString("result", tvResult?.text.toString())
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvExpression = findViewById(R.id.tvExpression)
        tvResult = findViewById(R.id.tvResult)
        tvClear = findViewById(R.id.tvClear)
        tvOne = findViewById(R.id.tvOne)
        tvTwo = findViewById(R.id.tvTwo)
        tvThree = findViewById(R.id.tvThree)
        tvFour = findViewById(R.id.tvFour)
        tvFive = findViewById(R.id.tvFive)
        tvSix = findViewById(R.id.tvSix)
        tvSeven = findViewById(R.id.tvSeven)
        tvEight = findViewById(R.id.tvEighnt)
        tvNine = findViewById(R.id.tvNine)
        tvZero = findViewById(R.id.tvZero)
        tvMul = findViewById(R.id.tvMul)
        tvDivision = findViewById(R.id.tvDivision)
        tvPlus = findViewById(R.id.tvPlus)
        tvMinus = findViewById(R.id.tvMinus)
        tvDot = findViewById(R.id.tvDot)
        tvEq = findViewById(R.id.tvEqual)
        tvPower = findViewById(R.id.tvPower)
        tvNegat = findViewById(R.id.tvNegat)
        tvSquare = findViewById(R.id.tvsquare)
        tvTripl = findViewById(R.id.tvtripl)
        tvFact = findViewById(R.id.tvfact)
        tvSqrt=findViewById(R.id.tvsqrt)
        tvSin=findViewById(R.id.tvSin)
        tvCos=findViewById(R.id.tvCos)
        tvTan=findViewById(R.id.tvTan)
        tvCot=findViewById(R.id.tvCot)
        //Numbers
        tvOne?.setOnClickListener { appendOnExpression(string = "1") }
        tvTwo?.setOnClickListener { appendOnExpression(string = "2") }
        tvThree?.setOnClickListener { appendOnExpression(string = "3") }
        tvFour?.setOnClickListener { appendOnExpression(string = "4") }
        tvFive?.setOnClickListener { appendOnExpression(string = "5") }
        tvSix?.setOnClickListener { appendOnExpression(string = "6") }
        tvSeven?.setOnClickListener { appendOnExpression(string = "7") }
        tvEight?.setOnClickListener { appendOnExpression(string = "8") }
        tvNine?.setOnClickListener { appendOnExpression(string = "9") }
        tvZero?.setOnClickListener { appendOnExpression(string = "0") }
        tvDot?.setOnClickListener { appendOnExpression(string = ".") }

        //Operations
        tvPlus?.setOnClickListener { appendOnExpression(string = "+") }
        tvMinus?.setOnClickListener { appendOnExpression(string = "-") }
        tvMul?.setOnClickListener { appendOnExpression(string = "*") }
        tvDivision?.setOnClickListener { appendOnExpression(string = "/") }
        tvPower?.setOnClickListener { appendOnExpression(string = "^") }
        tvSquare?.setOnClickListener { appendOnExpression(string = "^2") }
        tvTripl?.setOnClickListener { appendOnExpression(string = "^3") }
        tvFact?.setOnClickListener { factorial() }
        tvSqrt?.setOnClickListener { appendOnExpression(string = "√") }
        tvSin?.setOnClickListener { appendOnExpression(string = "sin") }
        tvCos?.setOnClickListener { appendOnExpression(string = "cos") }
        tvTan?.setOnClickListener { appendOnExpression(string = "tan") }
        tvCot?.setOnClickListener { appendOnExpression(string = "cot") }
        tvNegat?.setOnClickListener {
            if (tvExpression?.text!!.contains("+") || tvExpression?.text!!.contains("-")
                || tvExpression?.text!!.contains("*") || tvExpression?.text!!.contains("/")
            ) {
                try {
                    val ex = ExpressionBuilder(tvExpression?.text.toString()).build()
                    val res = ex.evaluate()
                    val longRes = res.toLong()
                    if (res == longRes.toDouble())
                        tvResult?.text = (longRes * (-1)).toString()
                    else
                        tvResult?.text = (res * (-1)).toString()
                } catch (e: Exception) {
                }
            } else
                tvResult?.text = "-" + tvExpression?.text
        }

        tvClear?.setOnClickListener {
            tvExpression?.text = ""
            tvResult?.text = ""
        }
        tvEq?.setOnClickListener {
            equalFunc()
        }

    }

    private fun appendOnExpression(string: String) {

        if (tvResult?.text != "") {
            tvExpression?.text = tvResult?.text
            tvResult?.text = ""
        }
        if(string==="√"){
            tvExpression?.text="sqrt("+tvExpression?.text+")"
        }
        else if(string==="cos"){
            tvExpression?.text="cos("+tvExpression?.text+")"
        }
        else if(string==="sin"){
            tvExpression?.text="sin("+tvExpression?.text+")"
        }
        else if(string==="tan"){
            tvExpression?.text="tan("+tvExpression?.text+")"
        }
        else if(string==="cot"){
            tvExpression?.text="1/tan("+tvExpression?.text+")"
        }
        else
            tvExpression?.append(string)
    }

    private fun equalFunc() {
        try {
            val ex = ExpressionBuilder(tvExpression?.text.toString()).build()
            val res = ex.evaluate()
            val longRes = res.toLong()
            if (res == longRes.toDouble())
                tvResult?.text = longRes.toString()
            else
                tvResult?.text = res.toString()
        } catch (e: Exception) {
        }
    }
    private fun factorial(){
        var s: Long = 0
        try {
            s = 1
            var i = 1
            while (i <=  abs(tvExpression?.text.toString().toDouble())) {
                s *= i.toLong()
                i++
            }
            tvResult?.text=s.toString()
        } catch (e: NumberFormatException) {

        }
    }
}