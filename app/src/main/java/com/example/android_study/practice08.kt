package com.example.android_study

import android.app.TabActivity
import android.os.Bundle

@Suppress("deprecation")
class practice08 : TabActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practice08)

        // tabHost 가져오기
        var tabHost = this.tabHost

        // 각 탭
        var tabDog = tabHost.newTabSpec("DOG").setIndicator("강아지")
        tabDog.setContent(R.id.tabDog)
        tabHost.addTab(tabDog) // tabHost 추가

        var tabCat = tabHost.newTabSpec("CAT").setIndicator("고양이")
        tabCat.setContent(R.id.tabCat)
        tabHost.addTab(tabCat) // tabHost 추가

        var tabRabbit = tabHost.newTabSpec("Rabbit").setIndicator("토끼")
        tabRabbit.setContent(R.id.tabRabbit)
        tabHost.addTab(tabRabbit) // tabHost 추가

        var tabHorse = tabHost.newTabSpec("HORSE").setIndicator("말")
        tabHorse.setContent(R.id.tabHorse)
        tabHost.addTab(tabHorse) // tabHost 추가
    }
}