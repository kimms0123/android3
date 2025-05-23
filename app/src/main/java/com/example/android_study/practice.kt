package com.example.android_study

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class practice : AppCompatActivity(){
    lateinit var edit1 : EditText; lateinit var edit2 : EditText
    lateinit var btnAdd : Button; lateinit var btnSub : Button
    lateinit var btnMul : Button; lateinit var btnDiv : Button
    lateinit var btnPri : Button // 추가
    lateinit var textResult : TextView
    lateinit var num1 : String; lateinit var num2 : String
    var result : Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practice)
        title = "초간단 계산기"

        edit1 = findViewById<EditText>(R.id.Edit1)
        edit2 = findViewById<EditText>(R.id.Edit2)
        btnAdd = findViewById<Button>(R.id.BtnAdd)
        btnSub = findViewById<Button>(R.id.BtnSub)
        btnMul = findViewById<Button>(R.id.BtnMul)
        btnDiv = findViewById<Button>(R.id.BtnDiv)
        textResult = findViewById<TextView>(R.id.TextResult)

            btnAdd.setOnTouchListener { view, motionEvent ->
                num1 = edit1.text.toString()
                num2 = edit2.text.toString()
                result = Integer.parseInt(num1) + Integer.parseInt(num2)
                textResult.text = "계산 결과: " + result.toString()
                false
            }
            btnSub.setOnTouchListener { view, motionEvent ->
                num1 = edit1.text.toString()
                num2 = edit2.text.toString()
                result = Integer.parseInt(num1) - Integer.parseInt(num2)
                textResult.text = "계산 결과: " + result.toString()
                false
            }
            btnMul.setOnTouchListener { view, motionEvent ->
                num1 = edit1.text.toString()
                num2 = edit2.text.toString()
                result = Integer.parseInt(num1) * Integer.parseInt(num2)
                textResult.text = "계산 결과: " + result.toString()
                false
            }
            btnDiv.setOnTouchListener { view, motionEvent ->
                num1 = edit1.text.toString()
                num2 = edit2.text.toString()
                result = Integer.parseInt(num1) / Integer.parseInt(num2)
                textResult.text = "계산 결과: " + result.toString()
                false
            }
    }
}