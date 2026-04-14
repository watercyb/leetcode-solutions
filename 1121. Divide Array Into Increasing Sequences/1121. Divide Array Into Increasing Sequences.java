/*
 * Problem: 1121. Divide Array Into Increasing Sequences
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/divide-array-into-increasing-sequences/
 * Language: java
 * Date: 2026-04-14
 */

class Solution {
    public boolean canDivideIntoSubsequences(int[] nums, int k) {
        int prv = 0;
        int count = 0;
        for (int num : nums) {
            if (num != prv) {
                prv = num;
                count = 1;
            } else {
                count++;
                if (count > nums.length / k)
                    return false;
            }
        }
        return true;
    }
}
