var capacitorDynamicColor = (function (exports, core) {
    'use strict';

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

    Object.defineProperty(exports, '__esModule', { value: true });

    return exports;

})({}, capacitorExports);
//# sourceMappingURL=plugin.js.map
