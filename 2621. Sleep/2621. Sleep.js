/*
 * Problem: 2621. Sleep
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/sleep/
 * Language: javascript
 * Date: 2026-04-29
 */

/**
 * @param {number} millis
 * @return {Promise}
 */
async function sleep(millis) {
    return new Promise((resolve) => {
        setTimeout(() => resolve(), millis);
    });
}

/** 
 * let t = Date.now()
 * sleep(100).then(() => console.log(Date.now() - t)) // 100
 */
