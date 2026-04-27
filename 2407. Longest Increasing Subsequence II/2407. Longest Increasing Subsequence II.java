/*
 * Problem: 2407. Longest Increasing Subsequence II
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/longest-increasing-subsequence-ii/
 * Language: java
 * Date: 2026-04-27
 */

class Solution {
    public int lengthOfLIS(int[] nums, int k) {
        max = 0;
        for (int num : nums) {
            max = Math.max(num, max);
        }
        int l = (int) Math.ceil(Math.log(max + 1) / Math.log(2));
        max = (int) Math.pow(2, l) - 1;
        arr = new int[2 * max + 1];
        for (int i = 0; i < nums.length; i++) {
            add(nums[i] + max, get(Math.max(nums[i] - k, 0) + max, nums[i] + max - 1) + 1);
        }
        return arr[0];
    }

    public int[] arr;
    public int max;

    public void add(int i, int num) {
        while (num > arr[i]) {
            arr[i] = num;
            i = (i - 1) / 2;
        }
    }

    public int get(int l, int r) {
        int res = 0;
        while (l < r) {
            if (l % 2 == 0)
                res = Math.max(arr[l++], res);
            if (r % 2 == 1)
                res = Math.max(arr[r--], res);
            l = (l - 1) / 2;
            r = (r - 1) / 2;
        }
        if (l == r)
            return Math.max(arr[l], res);
        return res;
    }
}
