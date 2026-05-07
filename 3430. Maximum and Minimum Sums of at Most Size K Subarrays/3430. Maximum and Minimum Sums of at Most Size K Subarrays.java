/*
 * Problem: 3430. Maximum and Minimum Sums of at Most Size K Subarrays
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/maximum-and-minimum-sums-of-at-most-size-k-subarrays/
 * Language: java
 * Date: 2026-05-07
 */

class Solution {
    public long minMaxSubarraySum(int[] nums, int k) {
        long max = max(nums, k);
        long min = min(nums, k);
        return max + min ;
    }

    public long min(int[] nums, int k) {
        int[] left = new int[nums.length];
        int[] MQ = new int[nums.length + 1];
        MQ[0] = -1;
        int idx = 1;
        for (int i = 0; i < nums.length; i++) {
            while (idx > 1 && nums[MQ[idx - 1]] > nums[i]) {
                idx--;
            }
            left[i] = Math.min(i - MQ[idx - 1], k);
            MQ[idx++] = i;
        }
        MQ = new int[nums.length + 1];
        MQ[0] = nums.length;
        idx = 1;
        long res = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            while (idx > 1 && nums[MQ[idx - 1]] >= nums[i]) {
                idx--;
            }
            int right = Math.min(MQ[idx - 1] - i, k);
            long count = (long) left[i] * right;
            if (left[i] + right - 1 > k)
                count -= (long) (left[i] + right - 1 - k + 1) * (left[i] + right - 1 - k) / 2;
            res += count * nums[i];
            MQ[idx++] = i;
        }
        return res;
    }

    public long max(int[] nums, int k) {
        int[] left = new int[nums.length];
        int[] MQ = new int[nums.length + 1];
        MQ[0] = -1;
        int idx = 1;
        for (int i = 0; i < nums.length; i++) {
            while (idx > 1 && nums[MQ[idx - 1]] < nums[i]) {
                idx--;
            }
            left[i] = Math.min(i - MQ[idx - 1], k);
            MQ[idx++] = i;
        }
        MQ = new int[nums.length + 1];
        MQ[0] = nums.length;
        idx = 1;
        long res = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            while (idx > 1 && nums[MQ[idx - 1]] <= nums[i]) {
                idx--;
            }
            int right = Math.min(MQ[idx - 1] - i, k);
            long count = (long) left[i] * right;
            if (left[i] + right - 1 > k)
                count -= (long) (left[i] + right - 1 - k + 1) * (left[i] + right - 1 - k) / 2;
            res += count * nums[i];
            MQ[idx++] = i;
        }
        return res;
    }
}
