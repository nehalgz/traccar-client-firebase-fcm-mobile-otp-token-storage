package `in`.csias.tcclient

import `in`.csias.tcclient.R
import android.app.Activity
import android.os.Build
import android.os.Bundle
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import androidx.appcompat.app.AppCompatActivity

import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.annotation.RequiresApi

class Privacy : AppCompatActivity() {
    private val webView: WebView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_privacy)

        /*  val wedData: String =  "<html><body><h1>Hello, Javatpoint!</h1></body></html>"
          val mimeType: String = "text/html"
          val utfType: String = "UTF-8"
          webView.loadData(wedData,mimeType,utfType)*/

        /* val myWebUrl: String = "file:///android_asset/index.html"
         webView.loadUrl(myWebUrl)*/
        val webView = findViewById<WebView>(R.id.webView)
        webView.webViewClient = MyWebViewClient(this)
        val webSettings = webView.settings
        webSettings.javaScriptEnabled = true
        webView.loadUrl("https://qmodi.com/temp/")
    }
    class MyWebViewClient internal constructor(private val activity: Activity) : WebViewClient() {

        @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
        override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
            val url: String = request?.url.toString();
            view?.loadUrl(url)
            return true
        }

        override fun shouldOverrideUrlLoading(webView: WebView, url: String): Boolean {
            webView.loadUrl(url)
            return true
        }

        override fun onReceivedError(view: WebView, request: WebResourceRequest, error: WebResourceError) {
            Toast.makeText(activity, "Got Error! $error", Toast.LENGTH_SHORT).show()
        }
    }
}