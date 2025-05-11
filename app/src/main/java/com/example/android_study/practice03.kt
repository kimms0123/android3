package com.example.android_study

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

/*
    XML 없이 화면 코딩
 */
class practice03 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_practice03)

        // LinearLayout.LayoutParams 변수 선언
        // 생성자에서 파라미터는 layout_width, layout_height 중 2개 지정 가능
        // layout_weight까지 지정해야하면, 생성자에서 파라미터 3개 전달
        val params = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.MATCH_PARENT)

        // 리니어레이아웃 변수 선언 (= <LinearLayout> </LinearLayout>)
        val baseLayout = LinearLayout(this)
        // orientation 속성 지정
        baseLayout.orientation = LinearLayout.VERTICAL
        // 레이아웃 색상 지정
        baseLayout.setBackgroundColor(Color.rgb(0,225,0))
        // 레이아웃 변수를 화면에 출력, 파라미터로 레이아웃 클래스와 레이아웃 사용
        setContentView(baseLayout,params)

        // 버튼 생성

        // 버튼 변수 생성
        // this(=context): 현재 클래스를 가리킴
        // Button 생성자는 버튼이 **어디에 붙을지(어느 화면에 표시될지)**를 알아야 하는데, 그 화면이 context라는 개념이다.
        // 여기서 Context는 "현재 앱 상태나 환경 정보"를 담고 있는 객체
        var btn = Button(this)
        // 버튼에 글자 설정
        btn.text = "버튼입니다"
        // 색상 지정
        btn.setBackgroundColor(Color.RED)
        // 레이아웃에 출력
        // baseLayout: 앞에서 생성한 리니어레이아웃
        // addView에 위젯 변수와 레이아웃 파라미터를 넘길 수 있음
        // 현재는 위젯 변수만 넘기고 이를 생략했는데 이때 default로 layout_weight는 match_parent가 되고 height는 wrap_content가 됨
        baseLayout.addView(btn)

        // 버튼 클릭시 작동하는 Toast 메세지
        btn.setOnClickListener {
            Toast.makeText(applicationContext,"코드로 생성한 버튼입니다",Toast.LENGTH_SHORT).show()
        }
    }
}