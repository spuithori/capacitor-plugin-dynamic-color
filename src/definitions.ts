export interface DynamicColorPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
