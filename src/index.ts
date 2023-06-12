import { registerPlugin } from '@capacitor/core';

import type { HijackPluginPlugin } from './definitions';

const HijackPlugin = registerPlugin<HijackPluginPlugin>('HijackPlugin', {
  web: () => import('./web').then(m => new m.HijackPluginWeb()),
});

export * from './definitions';
export { HijackPlugin };
