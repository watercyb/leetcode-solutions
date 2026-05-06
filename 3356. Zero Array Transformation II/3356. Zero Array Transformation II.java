/*
 * Problem: 3356. Zero Array Transformation II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/zero-array-transformation-ii/
 * Language: java
 * Date: 2026-05-06
 */

class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        int[] arr = new int[nums.length + 1];
        int j = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += arr[i];
            while (sum < nums[i] && j < queries.length) {
                if (queries[j][0] > i) {
                    arr[queries[j][0]] += queries[j][2];
                    arr[queries[j][1] + 1] -= queries[j][2];
                } else if (queries[j][1] >= i) {
                    sum += queries[j][2];
                    arr[queries[j][1] + 1] -= queries[j][2];
                }
                j++;
            }
            if (sum < nums[i])
                return -1;
        }
        return j;
    }
}
