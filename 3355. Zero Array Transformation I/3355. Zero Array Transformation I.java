/*
 * Problem: 3355. Zero Array Transformation I
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/zero-array-transformation-i/
 * Language: java
 * Date: 2026-05-06
 */

class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int[] line = new int[nums.length + 1];
        for (int[] query : queries) {
            line[query[0]]++;
            line[query[1] + 1]--;
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += line[i];
            if (sum < nums[i])
                return false;
        }
        return true;
    }
}
