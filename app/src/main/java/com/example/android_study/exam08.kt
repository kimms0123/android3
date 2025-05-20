package com.example.android_study

import android.app.TabActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
@Suppress("deprecation") // 아이스크림 샌드위치 이후 탭액티비티 사용하면 경고가 나오는것을 막기 위한 코드(없어도 무방함)

// 해당 TabActivity() 클래스는 Deprecated 되었기 때문에 TabLayout+viewPager or ViewPager2를 사용 하길 권장함
class exam08 : TabActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practice08)

        // exam08
        /*
        var tabHost = this.tabHost          // 탭 호스트 변수 생성

        // 탭스펙 생성
        var tabSpec1 = tabHost.newTabSpec("TAB1").setIndicator("탭에 출력될 글자")
        tabSpec1.setContent(R.id.tab1)   // 탭스펙을 탭과 연결
        tabHost.addTab(tabSpec1)            // 탭을 탭호스트에 부착
        // - tabSpec: 탭을 구성하는 요소들의 집합(= 탭스펙을 준비해 탭호스트에 붙여넣으면 탭이 됨)

        // TabHost 객체 가져오기
        var tabHost = this.tabHost

        // 1번 탭
        var tabSpecSong = tabHost.newTabSpec("SONG").setIndicator("음악별") // 탭의 고유 id 설정 및 탭 제목(화면에 표시 되는 텍스트)
        tabSpecSong.setContent(R.id.tabSong) // 탭을 클릭했을 때 보여줄 뷰 id 설정
        tabHost.addTab(tabSpecSong) // TabHost에 탭 추가

        // 2번 탭
        var tabSpecArtist = tabHost.newTabSpec("ARTIST").setIndicator("가수별")
        tabSpecArtist.setContent(R.id.tabArtist)
        tabHost.addTab(tabSpecArtist)

        // 3번 탭
        var tabSpecAlbum = tabHost.newTabSpec("ALBUM").setIndicator("앨범별")
        tabSpecAlbum.setContent(R.id.tabAlbum)
        tabHost.addTab(tabSpecAlbum)

        tabHost.currentTab = 0 // 처음 시작할 때 첫번째 탭("음악별")이 선택 되도록 설정
        */

    }
}