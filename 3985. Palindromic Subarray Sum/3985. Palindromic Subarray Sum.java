/*
 * Problem: 3985. Palindromic Subarray Sum
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/palindromic-subarray-sum/
 * Language: java
 * Date: 2026-07-13
 */

class Solution {
    public long getSum(int[] nums) {
        int[] arr = new int[nums.length * 2 + 1];
        long[] sums = new long[arr.length + 1];
        for (int i = 0; i < nums.length; i++) {
            arr[i * 2 + 1] = nums[i];
            sums[i * 2 + 1] = sums[i * 2];
            sums[i * 2 + 2] = sums[i * 2 + 1] + nums[i];
        }
        sums[sums.length - 1] = sums[sums.length - 2];
        int[] lens = new int[arr.length];
        int len = 0;
        int idx = -1;
        long res = 0;
        for (int i = 0; i < arr.length; i++) {
            int l = 1;
            int lim = idx + len - i;
            if (lim > 0)
                l = Math.min(lim, lens[2 * idx - i]);
            while (i - l >= 0 && i + l < arr.length && arr[i - l] == arr[i + l]) {
                l++;
            }
            lens[i] = l;
            if (i + l > idx + len) {
                idx = i;
                len = l;
            }
            res = Math.max(res, sums[i + l] - sums[i - l + 1]);
        }
        return res;
    }
}
