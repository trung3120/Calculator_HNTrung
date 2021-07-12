package com.example.calculator_trung

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Numbers
        tvOne.setOnClickListener{appendOnExpression("1", true)}
        tvTwo.setOnClickListener{appendOnExpression("2", true)}
        tvThree.setOnClickListener{appendOnExpression("3", true)}
        tvFour.setOnClickListener{appendOnExpression("4", true)}
        tvFive.setOnClickListener{appendOnExpression("5", true)}
        tvSix.setOnClickListener{appendOnExpression("6", true)}
        tvSeven.setOnClickListener{appendOnExpression("7", true)}
        tvEight.setOnClickListener{appendOnExpression("8", true)}
        tvNine.setOnClickListener{appendOnExpression("9", true)}
        tvZero.setOnClickListener{appendOnExpression("0", true)}
        tvDot.setOnClickListener{appendOnExpression(".", true)}

        //Operators
        tvPlus.setOnClickListener{appendOnExpression("+", false)}
        tvMinus.setOnClickListener{appendOnExpression("-", false)}
        tvMul.setOnClickListener{appendOnExpression("*", false)}
        tvDivide.setOnClickListener{appendOnExpression("/", false)}

        tvClear.setOnClickListener{
            tvExpression.text = ""
            tvResult.text = ""
        }

        tvEquals.setOnClickListener{
            try{
                val expression = ExpressionBuilder(tvExpression.text.toString()).build()
                val result = expression.evaluate()
                val longResult = result.toLong()
                if (result == longResult.toDouble())
                    tvResult.text = result.toString()
            }catch(e:Exception){
                Log.d("Exception","message : " + e.message)
            }
        }
    }

    fun appendOnExpression(string: String, canClear: Boolean){
        if (tvResult.text.isNotEmpty()){
            tvExpression.text = ""
        }
        if(canClear){
            tvResult.text = ""
            tvExpression.append(string)
        }else{
            tvExpression.append(tvResult.text)
            tvExpression.append(string)
            tvResult.text = ""
        }
    }
}