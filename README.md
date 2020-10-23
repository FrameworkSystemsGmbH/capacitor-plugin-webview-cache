# Capacitor WebCiewCache Plugin

The native Android `WebView` caches images. If images are replaced on the server but keep the same filename, the `WebView` still shows the cached images. This plugin makes it possible to clear the `WebView` cache if needed.

## What does it do?

The plugin calls the native `WebView.clearCache(true)` method that clears the cache and deletes all cache files.

## Install

```
npm install capacitor-plugin-webview-cache
npx cap sync
```

## Usage

```typescript
import { Plugins } from '@capacitor/core';

const { WebViewCache } = Plugins;

...

WebViewCache.clearCache();
```
