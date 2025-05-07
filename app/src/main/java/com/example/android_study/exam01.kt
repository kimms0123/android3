package com.example.android_study

import android.graphics.Color
import android.os.Bundle
import android.text.TextUtils
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class exam01 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        // 텍스트 속성을 변경하는 Kotlin 코드
        var tv1 : TextView
        var tv2 : TextView
        var tv3 : TextView

        tv1 = findViewById<TextView>(R.id.textView1)
        tv2 = findViewById<TextView>(R.id.textView2)
        tv3 = findViewById<TextView>(R.id.textView3)

        tv1.setText("안녕하세요")
        tv1.setTextColor(Color.RED)
        tv2.setTextSize(30.0f)
        tv2.setTypeface(android.graphics.Typeface.SERIF,
            android.graphics.Typeface.BOLD_ITALIC)
        tv3.setText("가나다라마바사아자차카타파하가나다라마바사아자차카타파하가가가가가각가가가가각가가가가가각")
        // tv3.setSingleLine(true) // setSingleLine()은 setMaxLines(1)과 setHorizontallyScrolling(ture)를 내부적으로 호출하나, 최신에서는
        // maxLines와 ellipsize를 사용하는 것이 더 좋음
        tv3.maxLines = 1
        tv3.ellipsize = TextUtils.TruncateAt.END

        /*
            XML 속성과 관련 메소드
            background          setBackgroundColor()        View 클래스
            clickable           setClickable()                  "
            focusable           setFocusable()                  "
            id                  setId()                         "
            longClickable       setLongClickable()              "
            padding             setPadding()                    "
            rotation            setRotation()                   "
            scaleX, scaleY      setScaleX(), setScaleY()        "
            visibility          setVisibility()                 "
            gravity             setGravity()                TextView 클래스
            inputType           setRawInputType()               "
            password            setTransformation()             "
            text                setText()                       "
            textColor           setTextColor()                  "
            textSize            setTextSize()                   "
         */
    }
}