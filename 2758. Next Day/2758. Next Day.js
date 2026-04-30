/*
 * Problem: 2758. Next Day
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/next-day/
 * Language: javascript
 * Date: 2026-04-30
 */

/** 
 * @return {string}
 */
Date.prototype.nextDay = function () {
    this.setDate(this.getDate() + 1);
    return this.toISOString().split('T')[0];
}

/**
 * const date = new Date("2014-06-20");
 * date.nextDay(); // "2014-06-21"
 */
