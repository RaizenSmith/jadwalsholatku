package com.example.jadwalsholatku;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class g extends AppCompatActivity{
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gmail);

        webView = (WebView) findViewById(R.id.gmail);
        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://mail.google.com/mail/u/0/#inbox");
    }
    @Override
    public void onBackPressed(){
        if (webView.canGoBack()){
            webView.goBack();
        }
        getActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
