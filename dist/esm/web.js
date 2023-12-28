import { WebPlugin } from '@capacitor/core';
export class DynamicColorWeb extends WebPlugin {
    async echo(options) {
        console.log('ECHO', options);
        return options;
    }
    getDynamicColors() {
        return Promise.resolve({ value: "" });
    }
}
//# sourceMappingURL=web.js.map