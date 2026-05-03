/*
 * Problem: 3036. Number of Subarrays That Match a Pattern II
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/number-of-subarrays-that-match-a-pattern-ii/
 * Language: java
 * Date: 2026-05-03
 */

class Solution {
    public int countMatchingSubarrays(int[] nums, int[] pattern) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                nums[i] = 1;
            } else if (nums[i] > nums[i + 1]) {
                nums[i] = -1;
            } else {
                nums[i] = 0;
            }
        }
        nums[nums.length - 1] = 2;
        int[] LPS = LPS(pattern);
        int idx = 0;
        int len = 0;
        int res = 0;
        while (idx < nums.length) {
            if (nums[idx] == pattern[len]) {
                if (++len == pattern.length) {
                    res++;
                    len = LPS[len - 1];
                }
                idx++;
            } else {
                if (len != 0) {
                    len = LPS[len - 1];
                } else {
                    idx++;
                }
            }
        }
        return res;
    }

    public int[] LPS(int[] a) {
        int[] res = new int[a.length];
        int idx = 1;
        int len = 0;
        while (idx < a.length) {
            if (a[idx] == a[len]) {
                res[idx++] = ++len;
            } else {
                if (len != 0) {
                    len = res[len - 1];
                } else {
                    idx++;
                }
            }
        }
        return res;
    }
}
