/*
 * Problem: 845. Longest Mountain in Array
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/longest-mountain-in-array/
 * Language: java
 * Date: 2026-04-09
 */

class Solution {
    public int longestMountain(int[] arr) {
        int[] left = new int[arr.length];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 0;
            }
        }
        int right = 0;
        int res = -1;
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] > arr[i + 1]) {
                right++;
                if (left[i] != 0)
                    res = Math.max(left[i] + right, res);
            } else {
                right = 0;
            }
        }
        return res + 1;
    }
}
