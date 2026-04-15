/*
 * Problem: 1248. Count Number of Nice Subarrays
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/count-number-of-nice-subarrays/
 * Language: java
 * Date: 2026-04-15
 */

class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int[] counts = new int[nums.length + 1 + k];
        counts[k] = 1;
        int res = 0;
        int count = k;
        for (int i = 0; i < nums.length; i++) {
            count += nums[i] & 1;
            counts[count]++;
            res += counts[count - k];
        }
        return res;
    }
}
