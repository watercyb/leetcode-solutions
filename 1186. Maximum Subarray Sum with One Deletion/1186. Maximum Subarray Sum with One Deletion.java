/*
 * Problem: 1186. Maximum Subarray Sum with One Deletion
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-subarray-sum-with-one-deletion/
 * Language: java
 * Date: 2026-04-14
 */

class Solution {
    public int maximumSum(int[] arr) {
        int[] left = new int[arr.length];
        int max = 0;
        int maxNum = Integer.MIN_VALUE;
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            left[i] = max;
            max += arr[i];
            if (max < 0) {
                max = 0;
            } else if (max > res) {
                res = max;
            }
            if (arr[i] > maxNum)
                maxNum = arr[i];
        }
        if (maxNum < 0)
            return maxNum;
        max = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            res = Math.max(left[i] + max, res);
            max += arr[i];
            if (max < 0)
                max = 0;
        }
        return res;
    }
}
