export interface HijackSqlitePlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
  deleteDatabase(database: {appID:string, name:string}): {result: boolean};
  copyToDocuments(database: {appID:string, name:string}): {result: boolean};
  copyToUserData(database: {appID:string, name:string}): {result: boolean};
}
