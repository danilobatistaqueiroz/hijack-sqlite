import { WebPlugin } from '@capacitor/core';

import type { HijackPluginPlugin } from './definitions';

export class HijackPluginWeb extends WebPlugin implements HijackPluginPlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
