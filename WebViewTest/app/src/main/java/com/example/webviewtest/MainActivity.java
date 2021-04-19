package com.example.webviewtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebView webView = findViewById(R.id.web_view);
        webView.getSettings().setJavaScriptEnabled(true); // 让WebView支持JavaScript脚本

        // 需要跳转网页时，希望目标网页仍在当前WebView中显示，而非打开浏览器
        webView.setWebViewClient(new WebViewClient());

        webView.loadUrl("https://www.baidu.com");
    }
}