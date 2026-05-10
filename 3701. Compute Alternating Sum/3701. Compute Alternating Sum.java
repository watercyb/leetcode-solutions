/*
 * Problem: 3701. Compute Alternating Sum
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/compute-alternating-sum/
 * Language: java
 * Date: 2026-05-10
 */

class Solution {
    public int alternatingSum(int[] nums) {
        int p = 1;
        int res = 0;
        for (int num : nums) {
            res += p * num;
            p = -p;
        }
        return res;
    }
}
