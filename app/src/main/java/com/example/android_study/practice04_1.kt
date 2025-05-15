package com.example.android_study

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class practice04_1 : AppCompatActivity() {

    // 두 개의 입력 필드를 위한 변수 선언 (EditText)
    lateinit internal var edit1: EditText
    lateinit internal var edit2: EditText

    // 사칙연산 버튼 선언 (덧셈, 뺄셈, 곱셈, 나눗셈)
    lateinit internal var btnadd: Button
    lateinit internal var btnsub: Button
    lateinit internal var btnMul: Button
    lateinit internal var btnDiv: Button

    // 결과 출력용 텍스트 뷰
    lateinit internal var textResult: TextView

    // 사용자 입력값을 저장할 문자열 변수
    lateinit internal var num1: String
    lateinit internal var num2: String

    // 계산 결과를 저장할 변수
    internal var result: Int? = null

    // 숫자 버튼을 담을 리스트 및 버튼 ID 배열
    internal var numButtons = ArrayList<Button>(10)
    internal var numBtnIDs = arrayOf(
        R.id.btnNum0, R.id.btnNum1, R.id.btnNum2, R.id.btnNum3, R.id.btnNum4,
        R.id.btnNum5, R.id.btnNum6, R.id.btnNum7, R.id.btnNum8, R.id.btnNum9,
    )

    internal var I: Int = 0 // 숫자 버튼 index 용도 (현재 미사용)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practice04_1)

        // 앱 타이틀 설정
        title = "테이블레이아웃 계산기"

        // XML에서 UI 요소를 찾아 변수에 할당
        edit1 = findViewById(R.id.Edit1)
        edit2 = findViewById(R.id.Edit2)
        btnadd = findViewById(R.id.plus)
        btnsub = findViewById(R.id.sub)
        btnMul = findViewById(R.id.mul)
        btnDiv = findViewById(R.id.div)
        textResult = findViewById(R.id.result)

        // ------------------------------
        // 사칙연산 버튼 이벤트 처리
        // ------------------------------
        // 덧셈 버튼 클릭 시
        btnadd.setOnTouchListener { v, event ->
            num1 = edit1.text.toString()
            num2 = edit2.text.toString() // 수정: edit1 -> edit2
            result = Integer.parseInt(num1) + Integer.parseInt(num2)
            textResult.text = "계산결과: $result"
            false
        }

        // 뺄셈 버튼 클릭 시
        btnsub.setOnTouchListener { v, event ->
            num1 = edit1.text.toString()
            num2 = edit2.text.toString() // 수정: edit1 -> edit2
            result = Integer.parseInt(num1) - Integer.parseInt(num2)
            textResult.text = "계산결과: $result"
            false
        }

        // 곱셈 버튼 클릭 시
        btnMul.setOnTouchListener { v, event ->
            num1 = edit1.text.toString()
            num2 = edit2.text.toString()
            result = Integer.parseInt(num1) * Integer.parseInt(num2)
            textResult.text = "계산결과: $result"
            false
        }

        // 나눗셈 버튼 클릭 시
        btnDiv.setOnTouchListener { v, event ->
            num1 = edit1.text.toString()
            num2 = edit2.text.toString()
            result = Integer.parseInt(num1) / Integer.parseInt(num2)
            textResult.text = "계산결과: $result"
            false
        }

        // ------------------------------
        // 숫자 버튼 초기화 및 이벤트 처리
        // ------------------------------

        // 숫자 버튼 0~9까지를 리스트에 담는다.
        for (i in 0..9) {
            numButtons.add(findViewById<Button>(numBtnIDs[i]))
        }

        // 숫자 버튼 클릭 이벤트 처리
        for (i in 0 until numBtnIDs.size) {
            numButtons[i].setOnClickListener {
                // 어떤 EditText가 선택되어 있는지 확인
                if (edit1.isFocused) {
                    // edit1이 선택되어 있다면 해당 버튼 숫자를 edit1에 추가
                    num1 = edit1.text.toString() + numButtons[i].text.toString()
                    edit1.setText(num1)
                } else if (edit2.isFocused) {
                    // edit2가 선택되어 있다면 해당 버튼 숫자를 edit2에 추가
                    num2 = edit2.text.toString() + numButtons[i].text.toString()
                    edit2.setText(num2)
                } else {
                    // 둘 다 선택되지 않았을 경우 경고 메시지 출력
                    Toast.makeText(applicationContext,
                        "먼저 에디트텍스트를 선택하세요", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
