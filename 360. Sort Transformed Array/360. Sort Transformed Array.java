/*
 * Problem: 360. Sort Transformed Array
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/sort-transformed-array/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int[] res = new int[nums.length];
        int i = 0;
        int j = nums.length - 1;
        if (a > 0) {
            int idx = nums.length - 1;
            while (i <= j) {
                int l = a * nums[i] * nums[i] + b * nums[i] + c;
                int r = a * nums[j] * nums[j] + b * nums[j] + c;
                if (l > r) {
                    res[idx--] = l;
                    i++;
                } else if (l < r) {
                    res[idx--] = r;
                    j--;
                } else {
                    res[idx--] = l;
                    if (i != j)
                        res[idx--] = r;
                    i++;
                    j--;
                }
            }
        } else {
            int idx = 0;
            while (i <= j) {
                int l = a * nums[i] * nums[i] + b * nums[i] + c;
                int r = a * nums[j] * nums[j] + b * nums[j] + c;
                if (l < r) {
                    res[idx++] = l;
                    i++;
                } else if (l > r) {
                    res[idx++] = r;
                    j--;
                } else {
                    res[idx++] = l;
                    if (i != j)
                        res[idx++] = r;
                    i++;
                    j--;
                }
            }
        }
        return res;
    }
}
