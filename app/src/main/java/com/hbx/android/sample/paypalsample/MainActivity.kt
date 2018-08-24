package com.hbx.android.sample.paypalsample

import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import kotlinx.android.synthetic.main.activity_main.*

/**
 * simple paypal checkout example
 * for PayPal support troubleshooting
 */
class MainActivity : AppCompatActivity() {
    companion object {
        private const val URL = "https://developer.paypal.com/demo/checkout/#/pattern/client"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initWebView()
    }

    private fun initWebView() {
        webview.settings.userAgentString = "PayPalSample/${BuildConfig.VERSION_NAME} (${Build.MANUFACTURER}; ${Build.MODEL}); os=${Build.VERSION.SDK_INT}"
        webview.settings.javaScriptEnabled = true
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.JELLY_BEAN_MR2) {
            WebView.setWebContentsDebuggingEnabled(true)
        }

        swipeRefreshLayout.setOnRefreshListener {
            webview.loadUrl(URL)
            swipeRefreshLayout.isRefreshing = false
        }

        webview.loadUrl(URL)
    }
}
