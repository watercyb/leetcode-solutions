/*
 * Problem: 2777. Date Range Generator
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/date-range-generator/
 * Language: javascript
 * Date: 2026-04-30
 */

/**
 * @param {string} start
 * @param {string} end
 * @param {number} step
 * @yields {string}
 */
var dateRangeGenerator = function* (start, end, step) {
    var date = new Date(start);
    var target = new Date(end);
    console.log(date <= target);
    while (date <= target) {
        yield date.toISOString().split('T')[0];
        date.setDate(date.getDate() + step);
    }
};

/**
 * const g = dateRangeGenerator('2023-04-01', '2023-04-04', 1);
 * g.next().value; // '2023-04-01'
 * g.next().value; // '2023-04-02'
 * g.next().value; // '2023-04-03'
 * g.next().value; // '2023-04-04'
 * g.next().done; // true
 */
