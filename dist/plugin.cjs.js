'use strict';

Object.defineProperty(exports, '__esModule', { value: true });

var core = require('@capacitor/core');

const DynamicColor = core.registerPlugin('DynamicColor', {
    web: () => Promise.resolve().then(function () { return web; }).then(m => new m.DynamicColorWeb()),
});

class DynamicColorWeb extends core.WebPlugin {
    async echo(options) {
        console.log('ECHO', options);
        return options;
    }
    getDynamicColors() {
        return Promise.resolve({ value: "" });
    }
}

var web = /*#__PURE__*/Object.freeze({
    __proto__: null,
    DynamicColorWeb: DynamicColorWeb
});

exports.DynamicColor = DynamicColor;
//# sourceMappingURL=plugin.cjs.js.map
