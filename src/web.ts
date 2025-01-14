import { WebPlugin } from '@capacitor/core';

import type { WebViewCachePlugin } from './definitions';
import { CacheModeOptions } from '.';

export class WebViewCacheWeb extends WebPlugin implements WebViewCachePlugin {
  async clearCache(): Promise<void> { }
  async setCacheMode(_options: CacheModeOptions): Promise<void> { }
}
