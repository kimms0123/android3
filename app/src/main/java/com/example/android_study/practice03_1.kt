package com.example.android_study

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class practice03_1 : AppCompatActivity() {
    lateinit var edit : EditText
    lateinit var btn : Button
    lateinit var tv : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        // 리니어 레이아웃의 설정
        var params = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.MATCH_PARENT)

        // 리니어 레이아웃 생성 및 설정
        val baseLayout = LinearLayout(this)
        baseLayout.orientation = LinearLayout.VERTICAL
        setContentView(baseLayout, params)

        // 에디트 텍스트 생성 및 설정
        edit = EditText(this)
        edit.setHint("입력하세요.")

        // 버튼 생성 및 설정
        btn = Button(this)
        btn.text = "버튼입니다."
        btn.setBackgroundColor(Color.rgb(134, 229, 127))
        btn.setTextColor(Color.BLACK)
        btn.setOnClickListener {
            var str = edit.text.toString()
            tv.setText(str)
        }

        // 텍스트뷰 생성 및 설정
        tv = TextView(this)
        tv.setTextColor(Color.MAGENTA)
        tv.setTextSize(20.0f)

        // 레이아웃에 뷰 달기
        baseLayout.addView(edit)
        baseLayout.addView(btn)
        baseLayout.addView(tv)
    }

}