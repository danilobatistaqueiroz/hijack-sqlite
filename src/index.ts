import { registerPlugin } from '@capacitor/core';

import type { HijackSqlitePlugin } from './definitions';

const HijackSqlite = registerPlugin<HijackSqlitePlugin>('HijackSqlite', {
  web: () => import('./web').then(m => new m.HijackSqliteWeb()),
});

export * from './definitions';
export { HijackSqlite };
