package com.example.android_study

import android.graphics.Color
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.CalendarView
import android.widget.Chronometer
import android.widget.DatePicker
import android.widget.RadioButton
import android.widget.TextView
import android.widget.TimePicker
import androidx.appcompat.app.AppCompatActivity

class exam06_1 : AppCompatActivity() {

    // UI 컴포넌트 선언
    lateinit var chrono : Chronometer       // 경과시간 표시용 크로노미터
    lateinit var rdoCal : RadioButton       // 날짜 선택 라디오 버튼
    lateinit var rdoTime : RadioButton      // 시간 선택 라디오 버튼
    lateinit var tPicker : TimePicker       // 시간 선택기
    lateinit var dPicker : DatePicker       // 날짜 선택기 (DatePicker 사용)
    lateinit var tvYear : TextView          // 선택된 연도 표시
    lateinit var tvMonth: TextView          // 선택된 월 표시
    lateinit var tvDay : TextView           // 선택된 일 표시
    lateinit var tvHour : TextView          // 선택된 시 표시
    lateinit var tvMinute : TextView        // 선택된 분 표시

    // 선택된 날짜 저장 변수
    var selectYear : Int = 0
    var selectMonth : Int = 0
    var selectDay : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practice06_1)   // 레이아웃 연결
        title = "시간 예약"                              // 액티비티 제목 설정

        // 레이아웃의 UI 컴포넌트 연결
        chrono = findViewById<Chronometer>(R.id.chronometer1)
        rdoCal = findViewById<RadioButton>(R.id.rdoCal)
        rdoTime = findViewById<RadioButton>(R.id.rdoTime)
        tPicker = findViewById<TimePicker>(R.id.timePicker1)
        dPicker = findViewById<DatePicker>(R.id.datePicker)
        tvYear = findViewById<TextView>(R.id.tvYear)
        tvMonth = findViewById<TextView>(R.id.tvMonth)
        tvDay = findViewById<TextView>(R.id.tvDay)
        tvHour = findViewById<TextView>(R.id.tvhour)
        tvMinute = findViewById<TextView>(R.id.tvminite)

        rdoCal.visibility = View.INVISIBLE
        rdoTime.visibility = View.INVISIBLE

        // 초기 상태로 시간, 날짜 선택기 모두 숨김
        tPicker.visibility = View.INVISIBLE
        dPicker.visibility = View.INVISIBLE

        // 날짜 선택 라디오 버튼 클릭 시 처리
        rdoCal.setOnClickListener {
            dPicker.visibility = View.VISIBLE         // DatePicker 보임
            tPicker.visibility = View.INVISIBLE       // TimePicker 숨김
        }
        // 시간 선택 라디오 버튼 클릭 시 처리
        rdoTime.setOnClickListener {
            dPicker.visibility = View.INVISIBLE       // DatePicker 숨김
            tPicker.visibility = View.VISIBLE         // TimePicker 보임
        }

        // 크로노미터 클릭 시 시작 동작
        chrono.setOnClickListener {
            chrono.base = SystemClock.elapsedRealtime()   // 기준 시간을 현재시간으로 초기화
            chrono.start()                                 // 크로노미터 시작
            Log.d("chronoTest", "click d ")                // 로그 출력 (디버깅용)
            chrono.setTextColor(Color.RED)                 // 글자색 빨간색 (진행 중 표시)
            rdoCal.visibility = View.VISIBLE
            rdoTime.visibility = View.VISIBLE
        }

        // 연도 텍스트뷰 롱 클릭 시 (예약 완료 역할)
        tvYear.setOnLongClickListener {
            chrono.stop()                                 // 크로노미터 정지
            chrono.setTextColor(Color.BLUE)                // 글자색 파란색 (완료 표시)

            // 선택한 날짜 출력
            tvYear.text = Integer.toString(selectYear)
            tvMonth.text = Integer.toString(selectMonth)
            tvDay.text = Integer.toString(selectDay)

            // 선택한 시간 출력
            tvHour.text = Integer.toString(tPicker.hour)
            tvMinute.text = Integer.toString(tPicker.minute)

            rdoCal.visibility = View.INVISIBLE
            rdoTime.visibility = View.INVISIBLE
            tPicker.visibility = View.INVISIBLE
            dPicker.visibility = View.INVISIBLE
            true    // 롱클릭 이벤트 소비
        }

        // DatePicker 날짜 변경 시 호출되는 리스너 등록
        dPicker.init(dPicker.year, dPicker.month, dPicker.dayOfMonth) { _, year, monthOfYear, dayOfMonth ->
            selectYear = year                // 선택된 연도 저장
            selectMonth = monthOfYear + 1   // 선택된 월 저장 (0부터 시작하므로 +1)
            selectDay = dayOfMonth           // 선택된 일 저장
        }
    }
}
