export interface HijackPluginPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
