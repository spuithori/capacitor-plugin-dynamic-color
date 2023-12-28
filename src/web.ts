import { WebPlugin } from '@capacitor/core';

import type { DynamicColorPlugin } from './definitions';

export class DynamicColorWeb extends WebPlugin implements DynamicColorPlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
