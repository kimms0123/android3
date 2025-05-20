package com.example.android_study

import android.os.Bundle
import android.widget.Button
import android.widget.ViewFlipper
import androidx.appcompat.app.AppCompatActivity

class practice07 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practice07)

        // 변수
        var btnStart : Button
        var btnEnd : Button
        var iFlipper : ViewFlipper

        // 화면 id 매칭
        btnStart = findViewById(R.id.btnStart)
        btnEnd = findViewById(R.id.btnEnd)
        iFlipper = findViewById(R.id.imgFlipper)

        // 버튼 이벤트
        btnStart.setOnClickListener {
            iFlipper.startFlipping() // 화면 넘김 시작 메소드
            iFlipper.flipInterval = 1000 // 화면 넘김 간격 메소드/ 변수명.flipInterval = 정수 (밀리세컨)
        }
        btnEnd.setOnClickListener {
            iFlipper.stopFlipping() // 화면 넘김 정지 메소드
        }
    }
}