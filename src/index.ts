import { registerPlugin } from '@capacitor/core';

import type { WebViewCachePlugin } from './definitions';

const WebViewCache = registerPlugin<WebViewCachePlugin>('WebViewCache', {
  web: () => import('./web').then(m => new m.WebViewCacheWeb()),
});

export * from './definitions';
export { WebViewCache };
