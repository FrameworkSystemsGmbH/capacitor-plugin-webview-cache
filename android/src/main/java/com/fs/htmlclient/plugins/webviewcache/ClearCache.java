package com.fs.htmlclient.plugins.webviewcache;

import android.webkit.WebView;

public class ClearCache implements Runnable {

    private WebView webView;

    public ClearCache(WebView webView) {
        this.webView = webView;
    }

    @Override
    public void run() {
        this.webView.clearCache(true);
    }
}
