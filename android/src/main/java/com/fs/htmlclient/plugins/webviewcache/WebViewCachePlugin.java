package com.fs.htmlclient.plugins.webviewcache;

import android.app.Activity;
import android.webkit.WebView;

import com.getcapacitor.Bridge;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

@CapacitorPlugin(name = "WebViewCache")
public class WebViewCachePlugin extends Plugin {

    @PluginMethod
    public void clearCache(PluginCall call) {
        try {
            Activity activity = this.getActivity();

            if (activity == null) {
                throw new Exception("Activity instance is null!");
            }

            Bridge bridge = this.getBridge();

            if (bridge == null) {
                throw new Exception("Bridge instance is null!");
            }

            WebView webView = bridge.getWebView();

            if (webView == null) {
                throw new Exception("WebView instance is null!");
            }

            activity.runOnUiThread(new ClearCache(webView));

            call.resolve();
        } catch (Exception ex) {
            call.reject(ex.getMessage(), ex);
        }
    }
}
