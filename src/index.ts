import { registerPlugin } from '@capacitor/core';

import type { DynamicColorPlugin } from './definitions';

const DynamicColor = registerPlugin<DynamicColorPlugin>('DynamicColor', {
  web: () => import('./web').then(m => new m.DynamicColorWeb()),
});

export * from './definitions';
export { DynamicColor };
