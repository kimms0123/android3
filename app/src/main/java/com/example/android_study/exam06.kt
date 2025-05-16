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
    lateinit var chrono : Chronometer
    lateinit var btnstart : Button
    lateinit var btnend : Button
    lateinit var rdoCal : RadioButton
    lateinit var rdoTime : RadioButton
    lateinit var calView : CalendarView
    lateinit var tPicker : TimePicker
    lateinit var tvYear : TextView
    lateinit var tvMonth: TextView
    lateinit var tvDay : TextView
    lateinit var tvHour : TextView
    lateinit var tvMinute : TextView
    var selectYear : Int = 0
    var selectMonth : Int = 0
    var selectDay : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practice06)
        title = "시간 예약"

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

        tPicker.visibility = View.INVISIBLE
        calView.visibility = View.INVISIBLE

        rdoCal.setOnClickListener {
            tPicker.visibility = View.INVISIBLE
            calView.visibility = View.VISIBLE
        }
        rdoTime.setOnClickListener {
            tPicker.visibility = View.VISIBLE
            calView.visibility = View.INVISIBLE
        }

        btnstart.setOnClickListener {
            chrono.base = SystemClock.elapsedRealtime()
            chrono.start()
            chrono.setTextColor(Color.RED)
        }
        btnend.setOnClickListener {
            chrono.stop()
            chrono.setTextColor(Color.BLUE)

            tvYear.text = Integer.toString(selectYear)
            tvMonth.text = Integer.toString(selectMonth)
            tvDay.text = Integer.toString(selectDay)

            tvHour.text = Integer.toString(tPicker.hour)
            tvMinute.text = Integer.toString(tPicker.minute)
        }

        calView.setOnDateChangeListener { view, year, month, dayOfMonth ->
            selectYear = year
            selectMonth = month + 1
            selectDay = dayOfMonth }


    }

}