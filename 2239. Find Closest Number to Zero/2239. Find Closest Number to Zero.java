/*
 * Problem: 2239. Find Closest Number to Zero
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/find-closest-number-to-zero/
 * Language: java
 * Date: 2026-04-25
 */

class Solution {
    public int findClosestNumber(int[] nums) {
        int res = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num >= 0 && num <= Math.abs(res)) {
                res = num;
            } else if (num < 0 && -num < Math.abs(res)) {
                res = num;
            }
        }
        return res;
    }
}
