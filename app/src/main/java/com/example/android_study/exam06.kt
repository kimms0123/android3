package com.example.android_study

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import android.widget.Button
import android.widget.CalendarView
import android.widget.Chronometer
import android.widget.RadioButton
import android.widget.TextView
import android.widget.TimePicker
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomappbar.BottomAppBarTopEdgeTreatment
import java.time.Month

class exam06 : AppCompatActivity() {

    // UI 컴포넌트 변수 선언
    lateinit var chrono : Chronometer            // 예약 경과 시간 표시용 크로노미터
    lateinit var btnstart : Button               // 예약 시작 버튼
    lateinit var btnend : Button                 // 예약 완료 버튼
    lateinit var rdoCal : RadioButton            // 날짜 설정 선택 라디오 버튼
    lateinit var rdoTime : RadioButton           // 시간 설정 선택 라디오 버튼
    lateinit var calView : CalendarView          // 날짜 선택 캘린더 뷰
    lateinit var tPicker : TimePicker             // 시간 선택 타임 피커
    lateinit var tvYear : TextView                // 선택한 연도 표시용 텍스트뷰
    lateinit var tvMonth: TextView                // 선택한 월 표시용 텍스트뷰
    lateinit var tvDay : TextView                  // 선택한 일 표시용 텍스트뷰
    lateinit var tvHour : TextView                 // 선택한 시 표시용 텍스트뷰
    lateinit var tvMinute : TextView               // 선택한 분 표시용 텍스트뷰

    // 날짜 선택 저장용 변수
    var selectYear : Int = 0
    var selectMonth : Int = 0
    var selectDay : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // activity_practice06 레이아웃을 현재 액티비티의 뷰로 설정
        setContentView(R.layout.activity_practice06)
        title = "시간 예약"  // 액티비티 제목 설정

        // 레이아웃 내 UI 컴포넌트와 변수 연결
        btnstart = findViewById<Button>(R.id.btnStart)
        btnend = findViewById<Button>(R.id.btnEnd)
        chrono = findViewById<Chronometer>(R.id.chronometer1)
        rdoCal = findViewById<RadioButton>(R.id.rdoCal)
        rdoTime = findViewById<RadioButton>(R.id.rdoTime)
        calView = findViewById<CalendarView>(R.id.calendarView1)
        tPicker = findViewById<TimePicker>(R.id.timePicker1)
        tvYear = findViewById<TextView>(R.id.tvYear)
        tvMonth = findViewById<TextView>(R.id.tvMonth)
        tvDay = findViewById<TextView>(R.id.tvDay)
        tvHour = findViewById<TextView>(R.id.tvhour)
        tvMinute = findViewById<TextView>(R.id.tvminite)

        // 처음에는 날짜와 시간 선택 위젯 모두 숨김 처리
        tPicker.visibility = View.INVISIBLE
        calView.visibility = View.INVISIBLE

        // 라디오 버튼 클릭 시 보이기/숨기기 처리
        rdoCal.setOnClickListener {
            tPicker.visibility = View.INVISIBLE     // 시간 선택기 숨김
            calView.visibility = View.VISIBLE       // 날짜 캘린더 보임
        }
        rdoTime.setOnClickListener {
            tPicker.visibility = View.VISIBLE       // 시간 선택기 보임
            calView.visibility = View.INVISIBLE     // 날짜 캘린더 숨김
        }

        // 예약 시작 버튼 클릭 이벤트
        btnstart.setOnClickListener {
            chrono.base = SystemClock.elapsedRealtime()  // 크로노미터 기준 시간을 현재 시간으로 초기화
            chrono.start()                               // 크로노미터 시작 (시간 흐름 시작)
            chrono.setTextColor(Color.RED)               // 글자색을 빨간색으로 변경 (진행 중 표시)
        }

        // 예약 완료 버튼 클릭 이벤트
        btnend.setOnClickListener {
            chrono.stop()                               // 크로노미터 정지 (시간 흐름 멈춤)
            chrono.setTextColor(Color.BLUE)              // 글자색을 파란색으로 변경 (완료 표시)

            // 선택된 날짜 정보를 텍스트뷰에 출력
            tvYear.text = Integer.toString(selectYear)
            tvMonth.text = Integer.toString(selectMonth)
            tvDay.text = Integer.toString(selectDay)

            // 선택된 시간 정보를 텍스트뷰에 출력
            tvHour.text = Integer.toString(tPicker.hour)
            tvMinute.text = Integer.toString(tPicker.minute)
        }

        // 캘린더에서 날짜 선택 이벤트 리스너
        calView.setOnDateChangeListener { view, year, month, dayOfMonth ->
            selectYear = year               // 선택한 연도 저장
            selectMonth = month + 1         // 선택한 월 저장 (month는 0부터 시작해서 +1 해줌)
            selectDay = dayOfMonth          // 선택한 일 저장
        }
    }
}
