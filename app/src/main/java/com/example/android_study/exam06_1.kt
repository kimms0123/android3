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
    lateinit var chrono : Chronometer
    lateinit var rdoCal : RadioButton
    lateinit var rdoTime : RadioButton
    lateinit var tPicker : TimePicker
    lateinit var dPicker : DatePicker
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
        setContentView(R.layout.activity_practice06_1)
        title = "시간 예약"

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

        tPicker.visibility = View.INVISIBLE
        dPicker.visibility = View.INVISIBLE

        rdoCal.setOnClickListener {
            dPicker.visibility = View.VISIBLE
            tPicker.visibility = View.INVISIBLE
        }
        rdoTime.setOnClickListener {
            dPicker.visibility = View.INVISIBLE
            tPicker.visibility = View.VISIBLE
        }

        chrono.setOnClickListener {
            chrono.base = SystemClock.elapsedRealtime()
            chrono.start()
            Log.d("chronoTest", "click d ")
            chrono.setTextColor(Color.RED)
        }
        tvYear.setOnLongClickListener {
            chrono.stop()
            chrono.setTextColor(Color.BLUE)

            tvYear.text = Integer.toString(selectYear)
            tvMonth.text = Integer.toString(selectMonth)
            tvDay.text = Integer.toString(selectDay)

            tvHour.text = Integer.toString(tPicker.hour)
            tvMinute.text = Integer.toString(tPicker.minute)
            true
        }

        dPicker.init(dPicker.year, dPicker.month, dPicker.dayOfMonth) { _, year, monthOfYear, dayOfMonth ->
            selectYear = year
            selectMonth = monthOfYear + 1
            selectDay = dayOfMonth
        }

    }

}