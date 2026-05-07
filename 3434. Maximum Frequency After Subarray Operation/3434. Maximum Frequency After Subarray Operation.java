/*
 * Problem: 3434. Maximum Frequency After Subarray Operation
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-frequency-after-subarray-operation/
 * Language: java
 * Date: 2026-05-07
 */

class Solution {
    public int maxFrequency(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) {
            if (num == k)
                sum++;
        }
        int max = 0;
        for (int i = 0; i <= 50; i++) {
            if (i != k)
                max = Math.max(getMax(nums, i, k), max);
        }
        return sum + max;
    }

    public int getMax(int[] nums, int a, int k) {
        int count = 0;
        int min = 0;
        int res = 0;
        for (int num : nums) {
            if (num == a) {
                count++;
            } else if (num == k) {
                count--;
            }
            res = Math.max(count - min, res);
            min = Math.min(count, min);
        }
        return res;
    }
}
