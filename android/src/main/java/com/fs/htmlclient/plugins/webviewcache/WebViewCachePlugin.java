package com.fs.htmlclient.plugins.webviewcache;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

@CapacitorPlugin(name = "WebViewCache")
public class WebViewCachePlugin extends Plugin {
    private WebViewCacheManager cacheManager;

    @Override
    public void load() {
        cacheManager = WebViewCacheManager.getInstance();
        cacheManager.initialize(bridge.getWebView());
    }

    @PluginMethod
    public void clearCache(PluginCall call) {
        cacheManager.clearCache(() -> {
            call.resolve();
        });
    }

    @PluginMethod
    public void setCacheMode(PluginCall call) {
        String modeStr = call.getString("mode", "LOAD_NO_CACHE");

        int mode;
        switch (modeStr) {
            case "LOAD_DEFAULT":
                mode = WebViewCacheMode.LOAD_DEFAULT;
                break;
            case "LOAD_CACHE_ELSE_NETWORK":
                mode = WebViewCacheMode.LOAD_CACHE_ELSE_NETWORK;
                break;
            case "LOAD_CACHE_ONLY":
                mode = WebViewCacheMode.LOAD_CACHE_ONLY;
                break;
            case "LOAD_NO_CACHE":
            default:
                mode = WebViewCacheMode.LOAD_NO_CACHE;
                break;
        }

        cacheManager.setCacheMode(mode, new WebViewCacheManager.CacheModeCallback() {
            @Override
            public void onSuccess(int currentMode) {
                String currentModeStr = "";
                switch (currentMode) {
                    case WebViewCacheMode.LOAD_DEFAULT:
                        currentModeStr = "LOAD_DEFAULT";
                        break;
                    case WebViewCacheMode.LOAD_CACHE_ELSE_NETWORK:
                        currentModeStr = "LOAD_CACHE_ELSE_NETWORK";
                        break;
                    case WebViewCacheMode.LOAD_CACHE_ONLY:
                        currentModeStr = "LOAD_CACHE_ONLY";
                        break;
                    case WebViewCacheMode.LOAD_NO_CACHE:
                        currentModeStr = "LOAD_NO_CACHE";
                        break;
                }
                call.resolve(new JSObject().put("currentMode", currentModeStr));
            }

            @Override
            public void onError(String error) {
                call.reject(error);
            }
        });
    }
}
