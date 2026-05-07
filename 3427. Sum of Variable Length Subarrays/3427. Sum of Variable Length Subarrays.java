/*
 * Problem: 3427. Sum of Variable Length Subarrays
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/sum-of-variable-length-subarrays/
 * Language: java
 * Date: 2026-05-07
 */

class Solution {
    public int subarraySum(int[] nums) {
        int[] swap = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            int idx = Math.max(i - nums[i], 0);
            swap[idx]++;
            swap[i + 1]--;
        }
        int count = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            count += swap[i];
            res += count * nums[i];
        }
        return res;
    }
}
