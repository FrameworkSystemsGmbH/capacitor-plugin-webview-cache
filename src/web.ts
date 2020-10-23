import { WebPlugin } from '@capacitor/core';
import { WebViewCachePlugin } from './definitions';

export class WebViewCacheWeb extends WebPlugin implements WebViewCachePlugin {
  constructor() {
    super({
      name: 'WebViewCache',
      platforms: ['web'],
    });
  }

  async clearCache(): Promise<void> { }
}

const WebViewCache = new WebViewCacheWeb();

export { WebViewCache };