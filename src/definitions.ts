declare module '@capacitor/core' {
  interface PluginRegistry {
    WebViewCache: WebViewCachePlugin;
  }
}

export interface WebViewCachePlugin {
  clearCache(): Promise<void>;
}
