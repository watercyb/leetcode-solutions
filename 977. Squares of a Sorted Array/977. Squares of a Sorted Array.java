/*
 * Problem: 977. Squares of a Sorted Array
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/squares-of-a-sorted-array/
 * Language: java
 * Date: 2026-04-10
 */

class Solution {
    public int[] sortedSquares(int[] nums) {
        int i = 0;
        while (i < nums.length && nums[i] < 0) {
            i++;
        }
        int j = i - 1;
        int[] res = new int[nums.length];
        int idx = 0;
        while (j >= 0 && i < nums.length) {
            if (nums[i] > -nums[j]) {
                res[idx] = nums[j] * nums[j];
                j--;
            } else {
                res[idx] = nums[i] * nums[i];
                i++;
            }
            idx++;
        }
        while (i < nums.length) {
            res[idx] = nums[i] * nums[i];
            i++;
            idx++;
        }
        while (j >= 0) {
            res[idx] = nums[j] * nums[j];
            j--;
            idx++;
        }
        return res;
    }
}
