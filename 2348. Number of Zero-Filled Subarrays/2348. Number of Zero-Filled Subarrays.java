/*
 * Problem: 2348. Number of Zero-Filled Subarrays
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/number-of-zero-filled-subarrays/
 * Language: java
 * Date: 2026-04-26
 */

class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long count = 0;
        long res = 0;
        for (int num : nums) {
            if (num != 0) {
                if (count > 0) {
                    res += (count + 1) * count / 2;
                    count = 0;
                }
            } else {
                count++;
            }
        }
        res += (count + 1) * count / 2;
        return res;
    }
}
