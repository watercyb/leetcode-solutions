/*
 * Problem: 3739. Count Subarrays With Majority Element II
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/count-subarrays-with-majority-element-ii/
 * Language: java
 * Date: 2026-05-10
 */

class Solution {
    public long countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        int[] counts = new int[2 * n + 1];
        int diff = n;
        counts[n] = 1;
        long sum = 0;
        long res = 0;
        for (int num : nums) {
            if (num == target) {
                sum += counts[diff];
                diff++;
            } else {
                diff--;
                sum -= counts[diff];
            }
            counts[diff]++;
            res+=sum;
        }
        return res;
    }
}
