package com.example.android_study

import android.os.Bundle
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class practice90 : AppCompatActivity() {

    // 구성 요소 선언
    lateinit var edtUrl : EditText // URL 입력창
    lateinit var btnGo : Button // 이동 버튼
    lateinit var btnBack : Button // 뒤로 가기 버튼
    lateinit var web : WebView // 웹 브라우저

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practice09)

        // 레이아웃 내 뷰 객체와 연결
        edtUrl = findViewById(R.id.edtUrl)
        btnGo = findViewById(R.id.btnGo)
        btnBack = findViewById(R.id.btnBack)
        web = findViewById(R.id.webView1)

        // 웹뷰에서 새 창을 띄우지 않고 앱 내에서 열리도록 설정
        web.webViewClient = CookWebViewClient()

        // 웹뷰 설정: 줌 컨트롤 사용 가능하게 설정
        var webSet = web.settings
        webSet.builtInZoomControls = true

        // [이동] 버튼 클릭 시 입력된 URL로 이동
        btnGo.setOnClickListener {
            web.loadUrl(edtUrl.text.toString()) // 입력된 URL을 로딩
        }

        // [이전] 버튼 클릭 시 웹 뷰에서 전 페이지로 이동
        btnBack.setOnClickListener {
            web.goBack()
        }
    }
}

// 커스텀 WebViewClient 클래스 정의
class CookWebViewClient : WebViewClient() {
    // 새로운 URL이 로드될 때 앱 내부 웹뷰에서 처리하게 함
    override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
        return super.shouldOverrideUrlLoading(view, request) // 기본 동작 유지
        // 필요시 view?.loadUrl(request?.url.toString())로 직접 로딩 가능
    }
}