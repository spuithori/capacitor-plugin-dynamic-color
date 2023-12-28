import { registerPlugin } from '@capacitor/core';
const DynamicColor = registerPlugin('DynamicColor', {
    web: () => import('./web').then(m => new m.DynamicColorWeb()),
});
export * from './definitions';
export { DynamicColor };
//# sourceMappingURL=index.js.map