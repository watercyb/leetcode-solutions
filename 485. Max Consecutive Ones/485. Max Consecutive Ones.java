/*
 * Problem: 485. Max Consecutive Ones
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/max-consecutive-ones/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0;
        int count = 0;
        for (int num : nums) {
            if (num == 0) {
                if (count > res)
                    res = count;
                count = 0;
            } else {
                count++;
            }
        }
        if (count > res)
            return count;
        return res;
    }
}
