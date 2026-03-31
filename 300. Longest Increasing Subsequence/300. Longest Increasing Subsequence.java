/*
 * Problem: 300. Longest Increasing Subsequence
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/longest-increasing-subsequence/
 * Language: java
 * Date: 2026-03-31
 */

class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] DP = new int[nums.length + 1];
        DP[0] = Integer.MIN_VALUE;
        int idx = 0;
        int res = 0;
        for (int num : nums) {
            int length = binarySearch(DP, idx, num);
            if (length > idx) {
                DP[++idx] = num;
                res = Math.max(length, res);
            } else if (DP[length] > num) {
                DP[length] = num;
            }
        }
        return res;
    }

    public int binarySearch(int[] DP, int idx, int num) {
        int l = 0;
        int r = idx + 1;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (DP[mid] >= num) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
