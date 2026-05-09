/*
 * Problem: 3667. Sort Array By Absolute Value
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/sort-array-by-absolute-value/description/
 * Language: java
 * Date: 2026-05-09
 */

class Solution {
    public int[] sortByAbsoluteValue(int[] nums) {
        int[] arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = Math.abs(nums[i]) * 201 + nums[i] + 100;
        }
        Arrays.sort(arr);
        for (int i = 0; i < nums.length; i++) {
            nums[i] = arr[i] % 201 - 100;
        }
        return nums;
    }
}
