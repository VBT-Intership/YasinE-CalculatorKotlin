package com.egesoftware.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.btnDeg
import kotlinx.android.synthetic.main.activity_main.btnE
import kotlinx.android.synthetic.main.activity_main.btnSin
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception
import kotlin.math.exp

const val E: Double = 2.71828
const val PI: Double = 3.14159
class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnDeg.setOnClickListener { appendOnExpression(string = "deg", canClear =true) }
        btnE.setOnClickListener { appendOnExpression(string = "e", canClear =true) }
        btnPi.setOnClickListener { appendOnExpression(string = "pi", canClear =true) }
        btnDot.setOnClickListener { appendOnExpression(string = ".", canClear =true) }

        btnNine.setOnClickListener { appendOnExpression(string = "9", canClear =true) }
        btnEight.setOnClickListener { appendOnExpression(string = "8", canClear =true) }
        btnSeven.setOnClickListener { appendOnExpression(string = "7", canClear =true) }
        btnSix.setOnClickListener { appendOnExpression(string = "6", canClear =true) }
        btnFive.setOnClickListener { appendOnExpression(string = "5", canClear =true) }
        btnFour.setOnClickListener { appendOnExpression(string = "4", canClear =true) }
        btnThree.setOnClickListener { appendOnExpression(string = "3", canClear =true) }
        btnTwo.setOnClickListener { appendOnExpression(string = "2", canClear =true) }
        btnOne.setOnClickListener { appendOnExpression(string = "1", canClear =true) }
        btnZero.setOnClickListener { appendOnExpression(string = "0", canClear =true) }

        //Operators
        btnPlus.setOnClickListener { appendOnExpression(string = "+", canClear =false) }
        btnMul.setOnClickListener { appendOnExpression(string = "*", canClear =false) }
        btnMinus.setOnClickListener { appendOnExpression(string = "-", canClear =false) }
        btnDivide.setOnClickListener { appendOnExpression(string = "/", canClear =false) }
        btnOpen.setOnClickListener { appendOnExpression(string = "(", canClear =false) }
        btnClose.setOnClickListener { appendOnExpression(string = ")", canClear =false) }

        btnEqual.setOnClickListener {  }
        btnClear.setOnClickListener {
            tvExpression.text = ""
            tvResult.text = ""
        }
/*
        btnClear.setOnClickListener {
            val string = tvExpression.text.toString()
            if(string.isNotEmpty()){
                tvExpression.text = string.substring(0,string.length-1)
            }
            tvResult.text = ""

        }
*/
        btnEqual.setOnClickListener {
            try {
                val expression = ExpressionBuilder(tvExpression.text.toString()).build()
                val result = expression.evaluate().toLong()
                tvResult.text = result.toString()

            }catch (e:Exception){

            }
        }

    }

    fun appendOnExpression(string : String, canClear : Boolean){
        if(tvExpression.text.isNotEmpty()){
            tvExpression.text = ""
        }

        if(canClear){
            tvResult.text = ""
            tvExpression.append(string)
        }else{
           val test = tvExpression.append(tvResult.text)
            Log.d("TEST LOG",test.toString())
            tvExpression.append(string)
            tvResult.text = ""
        }

    }
}
