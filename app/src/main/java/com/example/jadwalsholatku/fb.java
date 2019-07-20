package com.example.jadwalsholatku;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class fb extends AppCompatActivity{
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.facebook);

        webView = (WebView) findViewById(R.id.facebook);
        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://m.facebook.com/profile.php?id=100004320935521&ref=content_filter");
    }
    @Override
    public void onBackPressed(){
        if (webView.canGoBack()){
            webView.goBack();
        }
        getActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
