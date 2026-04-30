/*
 * Problem: 2723. Add Two Promises
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/add-two-promises/
 * Language: javascript
 * Date: 2026-04-30
 */

/**
 * @param {Promise} promise1
 * @param {Promise} promise2
 * @return {Promise}
 */
var addTwoPromises = async function (promise1, promise2) {
    let [a, b] = await Promise.all([promise1, promise2]);
    return a + b;
};

/**
 * addTwoPromises(Promise.resolve(2), Promise.resolve(2))
 *   .then(console.log); // 4
 */
