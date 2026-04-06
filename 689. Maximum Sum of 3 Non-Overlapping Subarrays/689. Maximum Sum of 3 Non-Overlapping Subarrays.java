/*
 * Problem: 689. Maximum Sum of 3 Non-Overlapping Subarrays
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/maximum-sum-of-3-non-overlapping-subarrays/
 * Language: java
 * Date: 2026-04-06
 */

class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int[] sums = new int[nums.length - k + 1];
        int[] left = new int[nums.length - k + 1];
        int[] right = new int[nums.length - k + 1];
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        sums[0] = sum;
        left[0] = 0;
        for (int i = k; i < nums.length; i++) {
            int idx = i - k + 1;
            sum += nums[i] - nums[idx - 1];
            sums[idx] = sum;
            if (sum > sums[left[idx - 1]]) {
                left[idx] = idx;
            } else {
                left[idx] = left[idx - 1];
            }
        }
        right[right.length - 1] = right.length - 1;
        int max = 0;
        int[] res = new int[3];
        for (int i = right.length - 2; i >= 0; i--) {
            if (sums[i] >= sums[right[i + 1]]) {
                right[i] = i;
            } else {
                right[i] = right[i + 1];
            }
            if (i >= k && i < sums.length - k) {
                sum = sums[left[i - k]] + sums[i] + sums[right[i + k]];
                if (sum >= max) {
                    max = sum;
                    res[0] = left[i - k];
                    res[1] = i;
                    res[2] = right[i + k];
                }
            }
        }
        return res;
    }
}
