package com.example.android_study

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction

@Suppress("deprecation")

// TabListener 인터페이스 구현
class exam08_1 : AppCompatActivity(), ActionBar.TabListener {

    // tab 변수 3개 선언
    lateinit var tabSong : ActionBar.Tab
    lateinit var tabArtist : ActionBar.Tab
    lateinit var tabAlbum : ActionBar.Tab

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // bar 뒤에 !!를 붙이면 bar 변수가 null이 아님을 의미(문법상 필요)
        // 현재 액티비티의 ActionBar(상단 바)를 가져옴
        var bar = this.supportActionBar
        //ActionBar가 null이 아님을 단언하고, 탭 네비게이션 모드로 설정
        // -> ActionBar에 탭을 추가해서 화면을 전환할 수 있도록 함
        bar!!.navigationMode = ActionBar.NAVIGATION_MODE_TABS

        // 첫번째 탭 [음악별]생성 및 액션바 추가
        tabSong = bar.newTab()
        tabSong.text = "음악별"
        tabSong.setTabListener(this)
        bar.addTab(tabSong)

        // 두번째 탭 [가수별]생성 및 액션바 추가
        tabArtist = bar.newTab()
        tabArtist.text = "가수별"
        tabArtist.setTabListener(this)
        bar.addTab(tabArtist)

        // 세번째 탭 [앨범별]생성 및 액션바 추가
        tabAlbum = bar.newTab()
        tabAlbum.text = "앨범별"
        tabAlbum.setTabListener(this)
        bar.addTab(tabAlbum)

    }

    // MyTabFragment 배열 선언 (3개의 프리그먼트(화면) 저장)
    var myFrags = arrayOfNulls<MyTabFragment>(3)
    // 탭을 선택하면 동작하는 코드 완성
    override fun onTabSelected(tab: ActionBar.Tab, ft: FragmentTransaction) {
        // 현재 선택한 프래그먼트(화면)로 사용할 변수
        var myTabFrag : MyTabFragment? = null

        // 선택한 탭이 기존에 한 번도 선택된 적이 없는 탭이라면 프래그먼트(화면)를 생성하여 ,myFrags[]의 해당 위치에 넣음
        if(myFrags[tab.position] == null) {
            // 새로운 프래그먼트 생성
            myTabFrag = MyTabFragment()
            // 현재 프래그먼트의 값 지정
            val data = Bundle()
            // 선택한 탭의 텍스트를 "tabName" 변수에 저장
            // 저장된 값은 MyTabFragment에 'var data = arguments' 에서 사용됨
            data.putString("tabName", tab.text.toString())
            myTabFrag.arguments = data
            // 생성한 프로그래먼트를 프래그먼트 배열의 해당 위치 [tab.getPosition()]에 저장
            myFrags[tab.position] = myTabFrag
        } else
            // 기존에 해당 탭을 선택한 적이 있다면 프래그먼트 배열에 이미 해당 프래그먼트가 생성되어 있으므로 재사용
            myTabFrag = myFrags[tab.position]

        // 새로 생성한 프래그먼트 또는 기존의 프래그먼트를 액션바 아래쪽에 출력
        ft.replace(android.R.id.content, myTabFrag!!)
    }

    // ActionBar.TabListener 구현 시 필수적으로 override 해야하는 콜백 함수 (필요할 경우에만 로직 넣으면 됨)
    // 사용자가 현재 선택된 탭이 아닌 다른 탭을 선택할 때 호출
    override fun onTabUnselected(tab: ActionBar.Tab, ft: FragmentTransaction) {}
    // 사용자가 이미 선택되어 있는 탭을 다시 클릭했을 때 호출
    override fun onTabReselected(tab: ActionBar.Tab, ft: FragmentTransaction) {}
}


// Fragment 클래스를 상속받은 MyTabFragment 클래스 생성
class MyTabFragment : androidx.fragment.app.Fragment() {

    // 탭의 이름을 저장할 변수(초기에는 null 상태)
    var tabName : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //현재 프래그먼트에 전달된 데이터 가져옴
        var data = arguments
        // 전달된 데이터에서 "tabName"이라는 키로 문자열 값을 꺼내서 tabName 변수에 저장
        tabName = data!!.getString("tabName")
    }

    // 프래그먼트에 나타날 화면 구성
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // 레아이웃의 가로, 세로, 크기를 Match_Parent로 설정하는 LayoutParams 생성
        var params = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT)

        // 프개그먼트에서 사용할 기본 LinerLayout 생성 (Activity context 사용)
        var baseLayout = LinearLayout(super.getActivity())
        // LinearLayout의 방향을 수직 방향으로 설정
        baseLayout.orientation = LinearLayout.VERTICAL
        // 생성한 LayoutParams를 baseLauout에 적용
        baseLayout.layoutParams = params

        // tabName 값에 따라 배경색을 다르게 설정
        if(tabName == "음악별") baseLayout.setBackgroundColor(Color.RED)
        if(tabName == "가수별") baseLayout.setBackgroundColor(Color.GREEN)
        if(tabName == "앨범별") baseLayout.setBackgroundColor(Color.BLUE)

        // 최종적으로 구성한 화면(View)을 반환
        return baseLayout
    }
}