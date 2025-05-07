package com.example.android_study

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
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
        setContentView(R.layout.activity_calculator)
        title = "초간단 계산기"

        edit1 = findViewById<EditText>(R.id.Edit1)
        edit2 = findViewById<EditText>(R.id.Edit2)
        btnAdd = findViewById<Button>(R.id.BtnAdd)
        btnSub = findViewById<Button>(R.id.BtnSub)
        btnMul = findViewById<Button>(R.id.BtnMul)
        btnDiv = findViewById<Button>(R.id.BtnDiv)
        btnPri = findViewById<Button>(R.id.BtnPri) // 추가
        textResult = findViewById<TextView>(R.id.TextResult)

        // 추가
        fun isValidInput(): Boolean{
            num1 = edit1.text.toString()
            num2 = edit2.text.toString()
            if(num1.isEmpty() || num2.isEmpty()){
                Toast.makeText(this, "값을 입력하세요", Toast.LENGTH_SHORT).show()
                return false
            }
            return true
        }
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

            // 추가
            // 터치가 아닌 클릭으로 변경 및 나머지 값을 구하는 버튼 추가 + 값을 입력하지 않고 버튼 클릭 시 오류 메세지 / 0으로 나누면 토스트 메세지 나타내고 계산 x
            btnPri.setOnClickListener {
                num1 = edit1.text.toString()
                num2 = edit2.text.toString()
                result = Integer.parseInt(num1) % Integer.parseInt(num2)
                textResult.text = "계산 결과: " + result.toString()
                false
            }

    }
}