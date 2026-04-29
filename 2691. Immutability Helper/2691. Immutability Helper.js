/*
 * Problem: 2691. Immutability Helper
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/immutability-helper/
 * Language: javascript
 * Date: 2026-04-29
 */

var ImmutableHelper = function (obj) {
    this.obj = obj;
};

/** 
 * @param {Function} mutator
 * @return {JSON} clone of obj
 */
ImmutableHelper.prototype.produce = function (mutator) {
    const getProxy = (current, target, callback) => {
        return new Proxy(current, {
            get(_, prop) {
                if (target[prop] === null) return null;
                if (current[prop] !== target[prop])
                    return current[prop];
                if (typeof target[prop] === 'object') {
                    return getProxy(current[prop], target[prop],
                        (k, v) => {
                            if (current[prop] === target[prop]) {
                                var temp;
                                if (Array.isArray(current[prop])) {
                                    temp = [...target[prop]];
                                } else {
                                    temp = { ...target[prop] };
                                }
                                temp[k] = v;
                                current = callback(prop, temp);
                            } else {
                                current[prop][k] = v;
                            }
                            return current[prop];
                        });
                }
                return current[prop];
            },
            set(_, prop, value) {
                current = callback(prop, value);
            },
        });
    };
    var res = [this.obj];
    const proxy = getProxy(res, [this.obj], (k, v) => {
        res[k] = v;
        return res;
    });
    mutator(proxy[0]);
    return res[0];
};

/**
 * const originalObj = {"x": 5};
 * const mutator = new ImmutableHelper(originalObj);
 * const newObj = mutator.produce((proxy) => {
 *   proxy.x = proxy.x + 1;
 * });
 * console.log(originalObj); // {"x: 5"}
 * console.log(newObj); // {"x": 6}
 */
