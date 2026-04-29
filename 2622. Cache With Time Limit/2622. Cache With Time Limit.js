/*
 * Problem: 2622. Cache With Time Limit
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/cache-with-time-limit/
 * Language: javascript
 * Date: 2026-04-29
 */

var TimeLimitedCache = function () {
    this.map = new Map();
};

/** 
 * @param {number} key
 * @param {number} value
 * @param {number} duration time until expiration in ms
 * @return {boolean} if un-expired key already existed
 */
TimeLimitedCache.prototype.set = function (key, value, duration) {
    var res = false;
    if (this.map.has(key)) {
        clearTimeout(this.map.get(key)[1]);
        res = true;
    }
    this.map.set(key, [value, setTimeout(() => { this.map.delete(key) }, duration)]);
    return res;
};

/** 
 * @param {number} key
 * @return {number} value associated with key
 */
TimeLimitedCache.prototype.get = function (key) {
    if (this.map.has(key)) return this.map.get(key)[0];
    return -1;
};

/** 
 * @return {number} count of non-expired keys
 */
TimeLimitedCache.prototype.count = function () {
    return this.map.size;
};

/**
 * const timeLimitedCache = new TimeLimitedCache()
 * timeLimitedCache.set(1, 42, 1000); // false
 * timeLimitedCache.get(1) // 42
 * timeLimitedCache.count() // 1
 */
