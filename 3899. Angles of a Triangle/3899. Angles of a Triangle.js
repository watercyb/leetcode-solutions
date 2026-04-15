/*
 * Problem: 3899. Angles of a Triangle
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/angles-of-a-triangle/
 * Language: javascript
 * Date: 2026-04-15
 */

/**
 * @param {number[]} sides
 * @return {number[]}
 */
var internalAngles = function(sides) {
    sides.sort((a, b) => a - b);
    if (sides[0]+sides[1]<=sides[2]) return [];
    let a=sides[0];
    let b=sides[1];
    let c=sides[2];
    let a2=a*a;
    let b2=b*b;
    let c2=c*c;
    let arr= [Math.acos((b2+c2-a2)/(2*b*c)) * (180 / Math.PI),Math.acos((a2+c2-b2)/(2*a*c)) * (180 / Math.PI),Math.acos((a2+b2-c2)/(2*a*b)) * (180 / Math.PI)];
    arr.sort((a, b) => a - b);
    return arr;
};
