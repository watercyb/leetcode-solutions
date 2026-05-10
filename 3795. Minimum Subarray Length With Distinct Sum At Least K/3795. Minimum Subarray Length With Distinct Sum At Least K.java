/*
 * Problem: 3795. Minimum Subarray Length With Distinct Sum At Least K
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-subarray-length-with-distinct-sum-at-least-k/
 * Language: java
 * Date: 2026-05-10
 */

class Solution {
    public int minLength(int[] nums, int k) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int[] counts = new int[max + 1];
        long sum = 0;
        int j = 0;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            while (j < nums.length && sum < k) {
                if (counts[nums[j]]++ == 0)
                    sum += nums[j];
                j++;
            }
            if (sum < k)
                break;
            res = Math.min(res, j - i);
            if (counts[nums[i]]-- == 1)
                sum -= nums[i];
        }
        if (res == Integer.MAX_VALUE)
            return -1;
        return res;
    }
}
