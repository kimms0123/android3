package com.example.android_study

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class practice02 : AppCompatActivity() {
    // 전역 변수 선언
    // lateinit var : 나중에 초기화할 변수를 선언할 때 사용(주로 null을 사용하지 않으면서도 나중에 값을 넣고 싶은 경우에 사용)
    lateinit var text1 : TextView
    lateinit var text2 : TextView
    lateinit var chkAgree : CheckBox
    lateinit var rGroup1 : RadioGroup
    lateinit var rdoDog : RadioButton
    lateinit var rdoCat : RadioButton
    lateinit var rdoRabbit : RadioButton
    lateinit var btnOk : Button
    lateinit var imgPet : ImageView

    // 각 위젯을 변수에 대입
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practice02)
        title = "애완동물 사진 보기"

        text1 = findViewById<TextView>(R.id.Text1)
        chkAgree = findViewById<CheckBox>(R.id.ChkAgree)

        text2 = findViewById<TextView>(R.id.Text2)
        rGroup1 = findViewById<RadioGroup>(R.id.RGroup1)
        rdoDog = findViewById<RadioButton>(R.id.RdoDog)
        rdoCat = findViewById<RadioButton>(R.id.RdoCat)
        rdoRabbit = findViewById<RadioButton>(R.id.RdoRabbit)

        btnOk = findViewById<Button>(R.id.BtnOk)
        imgPet = findViewById<ImageView>(R.id.ImgPet)

        // 시작함 체크박스를 체크, 언체크 할 때마다 동작하는 람다식 정의
        chkAgree.setOnCheckedChangeListener { compoundButton, b ->
            if (chkAgree.isChecked == true){
                text2.visibility = android.view.View.VISIBLE
                rGroup1.visibility = android.view.View.VISIBLE
                btnOk.visibility = android.view.View.VISIBLE
                imgPet.visibility = android.view.View.VISIBLE
            } else{
                text2.visibility = android.view.View.INVISIBLE
                rGroup1.visibility = android.view.View.INVISIBLE
                btnOk.visibility = android.view.View.INVISIBLE
                imgPet.visibility = android.view.View.INVISIBLE
            }
        }
        // <선택 완료> 클릭시 동작하는 람다식 정의
        btnOk.setOnClickListener{
            when(rGroup1.checkedRadioButtonId) {
                R.id.RdoDog -> imgPet.setImageResource(R.drawable.dog)
                R.id.RdoCat -> imgPet.setImageResource(R.drawable.cat)
                R.id.RdoRabbit -> imgPet.setImageResource(R.drawable.rabbit)
                else -> Toast.makeText(applicationContext,"동물 먼저 선택하세요", Toast.LENGTH_SHORT).show()
            }
        }
    }
}