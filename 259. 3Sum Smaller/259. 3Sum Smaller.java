/*
 * Problem: 3Sum Smaller
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/3sum-smaller/
 * Language: java
 * Date: 2026-03-31
 */

class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        target += 300;
        int[] sums1 = new int[target];
        int[] sums2 = new int[target];
        int res = 0;
        for (int num : nums) {
            num += 100;
            if (num >= target)
                continue;
            for (int i = 0; i < sums2.length - num; i++) {
                res += sums2[i];
            }
            for (int i = 0; i < sums1.length - num; i++) {
                sums2[i + num] += sums1[i];
            }
            sums1[num]++;
        }
        return res;
    }
}
