import { WebViewCacheMode } from './index';

export interface WebViewCachePlugin {
  clearCache(): Promise<void>;
  setCacheMode(options: {
    mode: WebViewCacheMode;
  }): Promise<void>;
}
