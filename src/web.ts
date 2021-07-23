import { WebPlugin } from '@capacitor/core';

import type { WebViewCachePlugin } from './definitions';

export class WebViewCacheWeb extends WebPlugin implements WebViewCachePlugin {
  async clearCache(): Promise<void> { }
}
