package com.fs.htmlclient.plugins.webviewcache;

import android.webkit.WebView;
import android.webkit.WebSettings;
import android.util.Log;
import android.os.Handler;
import android.os.Looper;

public class WebViewCacheManager {
    private static final String TAG = "WebViewCacheManager";
    private static WebViewCacheManager instance;
    private WebView webView;
    private final Handler mainHandler;

    private WebViewCacheManager() {
        mainHandler = new Handler(Looper.getMainLooper());
    }

    public static synchronized WebViewCacheManager getInstance() {
        if (instance == null) {
            instance = new WebViewCacheManager();
            Log.d(TAG, "Created new WebViewCacheManager instance");
        }
        return instance;
    }

    public void initialize(WebView webView) {
        this.webView = webView;
        Log.d(TAG, "Initialized WebViewCacheManager with WebView");
    }

    public void setCacheMode(int mode, final CacheModeCallback callback) {
        if (webView == null) {
            Log.e(TAG, "WebView not initialized. Call initialize() first.");
            callback.onError("WebView not initialized");
            return;
        }

        mainHandler.post(() -> {
            try {
                WebSettings settings = webView.getSettings();
                settings.setCacheMode(mode);
                int currentMode = settings.getCacheMode();
                Log.i(TAG, "Cache mode set to: " + currentMode);
                callback.onSuccess(currentMode);
            } catch (Exception e) {
                Log.e(TAG, "Error setting cache mode: " + e.getMessage(), e);
                callback.onError(e.getMessage());
            }
        });
    }

    public void clearCache(final Runnable onComplete) {
        if (webView == null) {
            Log.e(TAG, "WebView not initialized. Call initialize() first.");
            return;
        }

        mainHandler.post(() -> {
            try {
                Log.i(TAG, "Clearing WebView cache...");
                webView.clearCache(true);
                Log.i(TAG, "Cache cleared successfully");
                if (onComplete != null) {
                    onComplete.run();
                }
            } catch (Exception e) {
                Log.e(TAG, "Error clearing cache: " + e.getMessage(), e);
            }
        });
    }

    public interface CacheModeCallback {
        void onSuccess(int currentMode);
        void onError(String error);
    }
}
