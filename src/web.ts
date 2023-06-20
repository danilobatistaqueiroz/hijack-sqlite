import { WebPlugin } from '@capacitor/core';

import type { HijackSqlitePlugin } from './definitions';

export class HijackSqliteWeb extends WebPlugin implements HijackSqlitePlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
  deleteDatabase(database:{appID:string,name:string}): {result:boolean} {
    console.log(`nothing done ${database.appID}`);
    console.error('only works on android devices');
    return {result:false};
  }
  copyToDocuments(database:{appID:string,name:string}): {result:boolean} {
    console.log(`nothing done copy using ${database.appID} and ${database.name}`);
    console.error('only works on android devices');
    return {result:false};
  }
  copyToUserData(database:{appID:string,name:string}): {result:boolean} {
    console.log(`nothing done copy using ${database.appID} and ${database.name}`);
    console.error('only works on android devices');
    return {result:false};
  }
}
