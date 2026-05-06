/*
 * Problem: 3346. Maximum Frequency of an Element After Performing Operations I
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-frequency-of-an-element-after-performing-operations-i/
 * Language: java
 * Date: 2026-05-06
 */

class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(num, max);
        }
        int[] counts = new int[max + 1];
        for (int num : nums) {
            counts[num]++;
        }
        int res = 0;
        int j = 0;
        int left = 0;
        int right = 0;
        for (int i = 0; i <= max; i++) {
            while (j <= max && j - i <= k) {
                right += counts[j];
                j++;
            }
            right -= counts[i];
            res = Math.max(counts[i] + Math.min(left + right, numOperations), res);
            left += counts[i];
            if (i - k >= 0) {
                left -= counts[i - k];
            }
        }
        return res;
    }
}
