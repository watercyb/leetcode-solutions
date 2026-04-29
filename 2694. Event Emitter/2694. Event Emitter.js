/*
 * Problem: 2694. Event Emitter
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/event-emitter/
 * Language: javascript
 * Date: 2026-04-29
 */

class EventEmitter {
    map = new Map();
    /**
     * @param {string} eventName
     * @param {Function} callback
     * @return {Object}
     */
    subscribe(eventName, callback) {
        if (!this.map.has(eventName)) this.map.set(eventName, []);
        var arr = this.map.get(eventName);
        var idx = arr.length;
        arr.push(callback);
        return {
            unsubscribe: () => {
                arr[idx] = null;
            }
        };
    }

    /**
     * @param {string} eventName
     * @param {Array} args
     * @return {Array}
     */
    emit(eventName, args = []) {
        if (!this.map.has(eventName)) return [];
        var arr = this.map.get(eventName);
        var res = [];
        for (let callback of arr) {
            if (callback != null) res.push(callback(...args));
        }
        return res;
    }
}

/**
 * const emitter = new EventEmitter();
 *
 * // Subscribe to the onClick event with onClickCallback
 * function onClickCallback() { return 99 }
 * const sub = emitter.subscribe('onClick', onClickCallback);
 *
 * emitter.emit('onClick'); // [99]
 * sub.unsubscribe(); // undefined
 * emitter.emit('onClick'); // []
 */
