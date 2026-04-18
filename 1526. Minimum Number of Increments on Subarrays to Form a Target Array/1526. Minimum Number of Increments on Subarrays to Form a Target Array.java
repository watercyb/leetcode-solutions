/*
 * Problem: 1526. Minimum Number of Increments on Subarrays to Form a Target Array
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimum-number-of-increments-on-subarrays-to-form-a-target-array/
 * Language: java
 * Date: 2026-04-18
 */

class Solution {
    public int minNumberOperations(int[] target) {
        int prv = 0;
        int res = 0;
        for (int num : target) {
            res += Math.max(num - prv, 0);
            prv = num;
        }
        return res;
    }
}
