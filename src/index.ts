import { registerPlugin } from '@capacitor/core';
import type { WebViewCachePlugin } from './definitions';

const WebViewCache = registerPlugin<WebViewCachePlugin>('WebViewCache', {
  web: () => import('./web').then((m) => new m.WebViewCacheWeb()),
});

enum WebViewCacheMode {
  LOAD_DEFAULT = 'LOAD_DEFAULT',
  LOAD_CACHE_ELSE_NETWORK = 'LOAD_CACHE_ELSE_NETWORK',
  LOAD_NO_CACHE = 'LOAD_NO_CACHE',
  LOAD_CACHE_ONLY = 'LOAD_CACHE_ONLY',
}
type CacheModeOptions = {
  mode: WebViewCacheMode;
};

export * from './definitions';
export { WebViewCache, WebViewCacheMode };
export type { CacheModeOptions, WebViewCachePlugin };

