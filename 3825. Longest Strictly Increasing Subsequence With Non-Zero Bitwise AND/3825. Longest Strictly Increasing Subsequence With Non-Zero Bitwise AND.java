/*
 * Problem: 3825. Longest Strictly Increasing Subsequence With Non-Zero Bitwise AND
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/longest-strictly-increasing-subsequence-with-non-zero-bitwise-and/
 * Language: java
 * Date: 2026-05-11
 */

class Solution {
    public int longestSubsequence(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        arr = new int[nums.length];
        int res = 0;
        for (int i = 1; i <= max; i <<= 1) {
            res = Math.max(res, chk(nums, i));
        }
        return res;
    }

    int[] arr;

    public int chk(int[] nums, int n) {
        int idx = 0;
        for (int num : nums) {
            if ((num & n) != 0) {
                int id = binarySearch(idx, num);
                if (id == idx)
                    idx++;
                arr[id] = num;
            }
        }
        return idx;
    }

    public int binarySearch(int lim, int target) {
        int l = 0;
        int r = lim;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (arr[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
