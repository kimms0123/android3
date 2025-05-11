package com.example.android_study

import android.graphics.Color
import android.os.Bundle
import android.provider.CalendarContract.Colors
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class practice03_1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 레이아웃
        val params = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.MATCH_PARENT
        )

        val baseLayout = LinearLayout(this)
        baseLayout.orientation = LinearLayout.VERTICAL
        setContentView(baseLayout, params)

        // EditText
        var editText = EditText(this)
        editText.hint = "IT CookBook.Android"
        baseLayout.addView(editText)

        // Button
        var btn = Button(this)
        btn.text = "버튼입니다."
        btn.setBackgroundColor(Color.YELLOW)
        baseLayout.addView(btn)

        // TextView
        var textView = TextView(this)
        textView.setTextColor(Color.MAGENTA)
        baseLayout.addView(textView)

        // btn 동작
        btn.setOnClickListener {
            var text = editText.text.toString()
            textView.text = text
        }
    }
}