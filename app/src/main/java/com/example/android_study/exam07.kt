package com.example.android_study

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.MultiAutoCompleteTextView
import android.widget.ViewFlipper
import androidx.appcompat.app.AppCompatActivity

class exam07 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exam07_2)

//        // 자동완성 코드
//        // 자동완성에 사용될 문자열의 배열 정의
//        var items = arrayOf("CSI-뉴욕", " CSI-라스베가스","CSI-마이애미","Friends", "Fringe", "Lost")
//        // XML 레이아웃에서 AutoCompleteTextView 컴포넌트를 찾아 변수에 저장
//        // AutoCompleteTextView: 입력한 내용을 기반으로 자동완성 제안을 하나 표시
//        var auto = findViewById<AutoCompleteTextView>(R.id.autoCompleteTextView1)
//        // 문자열 배열을 기반으로 한 ArrayAdapter(자동 완성 후보 데이터를 연결해주는 중간 다리 역할) 생성
//        // 안드로이드 기본 제공 레이아웃(simple_dropdown_item_1line)을 사용
//        // simple_dropdown_item_1line: 드롭다운에 나타나는 항목 하나 하나의 모양 정의 (= 리스트에 표시될 각 줄(아이템)이 어떻게 보일지 레이
//        var adapter = ArrayAdapter(this,android.R.layout.simple_dropdown_item_1line, items)
//        // AutoCompleteTextView에 어댑터를 연결하여 자동완성 기능 활성화
//        auto.setAdapter(adapter)
//
//        // XML 레이아웃에서 MultiAutoCompleteTextView 컴포넌트를 변수에 저장
//        // MultiAutoCompleteTextView: 입력한 여러 항목 각각에 대해 자동완성 제안
//        var multi = findViewById<MultiAutoCompleteTextView>(R.id.multiAutoCompleteTextView)
//        // 쉼표를 기준으로 여러 단어를 구분해 자동완성을 수행하도록 설정
//        var token = MultiAutoCompleteTextView.CommaTokenizer()
//        multi.setTokenizer(token)
//        // MultiAutoCompleteTextView에도 동일한 어댑터를 연결하여 자동완성 기능 활성화
//        multi.setAdapter(adapter)

        // 뷰 퍼블리퍼 코드
        var btnPrev = findViewById<Button>(R.id.btnPrev)
        var btnNext = findViewById<Button>(R.id.btnNext)
        var vFlipper = findViewById<ViewFlipper>(R.id.viewFlipper1)

        btnPrev.setOnClickListener {
            vFlipper.showPrevious()
        }
        btnNext.setOnClickListener {
            vFlipper.showNext()
        }
    }
}