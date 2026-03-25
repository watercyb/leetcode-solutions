/*
 * Problem: 75. Sort Colors
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/sort-colors/
 * Language: java
 * Date: 2026-03-25
 */

class Solution {
    public void sortColors(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int k = 0;
        while (k <= r) {
            if (nums[k] == 0) {
                swap(nums, l, k);
                l++;
                k++;
            } else if (nums[k] == 2) {
                swap(nums, r, k);
                r--;
            } else {
                k++;
            }
        }
    }

    public void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
