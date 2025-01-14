package com.fs.htmlclient.plugins.webviewcache;

import android.webkit.WebSettings;

/**
 * Constants class defining the available WebView cache modes
 */
public final class WebViewCacheMode {
    private WebViewCacheMode() {
        // Prevent instantiation
    }

    /**
     * Default cache usage mode. If the navigation type doesn't impose any specific behavior,
     * use cached resources when they are available and not expired, otherwise load from network.
     */
    public static final int LOAD_DEFAULT = WebSettings.LOAD_DEFAULT;

    /**
     * Use cached resources when they are available, even if they have expired.
     * If there are no cached resources available, load from network.
     */
    public static final int LOAD_CACHE_ELSE_NETWORK = WebSettings.LOAD_CACHE_ELSE_NETWORK;

    /**
     * Don't use the cache, load from network only.
     */
    public static final int LOAD_NO_CACHE = WebSettings.LOAD_NO_CACHE;

    /**
     * Don't use the network, load from cache only.
     */
    public static final int LOAD_CACHE_ONLY = WebSettings.LOAD_CACHE_ONLY;
}
