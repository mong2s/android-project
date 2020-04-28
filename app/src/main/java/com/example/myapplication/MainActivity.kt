package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.http.SslError
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.webkit.SslErrorHandler
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        const val PAGE_URL = "https://resttesttest.com/"
        const val MAX_PROGRESS = 100

        fun newIntent(context: Context, pageUrl: String): Intent {
            val intent = Intent(context, MainActivity::class.java)
            intent.putExtra(PAGE_URL, pageUrl)
            return intent
        }
    }

    private lateinit var pageUrl: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initUI()
        initWebView()
        setWebClient()
        handlePullToRefresh()
        loadUrl(PAGE_URL)

    }

    ////////////////////////////////////////////////////////////////
    // UI set
    ////////////////////////////////////////////////////////////////
    private fun initUI() {
        NextButton.setOnClickListener{
            val nextActivityIntnent = Intent(this, RestfulSampleActivity::class.java)
            nextActivityIntnent.putExtra("nextTestString","mong2s")
            nextActivityIntnent.putExtra("nextTestInt",123456780)
            startActivity(nextActivityIntnent)
        }
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun initWebView() {
        webView.settings.javaScriptEnabled = true
        webView.settings.loadWithOverviewMode = true
        webView.settings.useWideViewPort = true
        webView.settings.domStorageEnabled = true

        webView.webViewClient = object : WebViewClient() {
            override
            fun onReceivedSslError(view: WebView?, handler: SslErrorHandler?, error: SslError?) {
                handler?.proceed()
            }
        }

    }


    ////////////////////////////////////////////////////////////////
    // Key control
    ////////////////////////////////////////////////////////////////
    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()) {
            webView.goBack()
            return true
        }
        return super.onKeyDown(keyCode, event)
    }




    ////////////////////////////////////////////////////////////////
    // web view control
    ////////////////////////////////////////////////////////////////
    private fun handlePullToRefresh() {

    }

    private fun setWebClient() {
        webView.webChromeClient = object : WebChromeClient() {
            override fun onProgressChanged(
                view: WebView,
                newProgress: Int
            ) {
                super.onProgressChanged(view, newProgress)
                progressBar.progress = newProgress
                if (newProgress < MAX_PROGRESS && progressBar.visibility == ProgressBar.GONE) {
                    progressBar.visibility = ProgressBar.VISIBLE
                }

                if (newProgress == MAX_PROGRESS) {
                    progressBar.visibility = ProgressBar.GONE
                }
            }
        }
    }


    private fun loadUrl(pageUrl: String) {
        webView.loadUrl(pageUrl)

        Log.i("mong","pageUrl : " + pageUrl);
    }




}
