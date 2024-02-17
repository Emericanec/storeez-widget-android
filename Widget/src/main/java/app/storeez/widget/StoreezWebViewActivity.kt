package app.storeez.widget

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.webkit.JavascriptInterface
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class StoreezWebViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.storeez_webview)

        val toolbar: Toolbar? = findViewById(R.id.storeezWebViewToolbar)
        if (null != toolbar) {
            setSupportActionBar(toolbar)
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            supportActionBar?.title = ""
            toolbar.setNavigationOnClickListener {
                finish()
            }
        }

        val url: String? = intent.getStringExtra("url")
        val webView: WebView = findViewById(R.id.storeezWebView)
        webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
                val url = request?.url.toString()
                if (url.startsWith("http://") || url.startsWith("https://")) {
                    startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
                    return true
                }
                return false
            }
        }

        webView.settings.javaScriptEnabled = true
        webView.settings.mediaPlaybackRequiresUserGesture = false

        webView.addJavascriptInterface(JsInterface(this), "Android")

        if (url != null) {
            println(url)
            webView.loadUrl(url)
        }
    }

    private class JsInterface(private val activity: AppCompatActivity) {
        @JavascriptInterface
        fun closeWebView() {
            activity.finish()
        }
    }
}