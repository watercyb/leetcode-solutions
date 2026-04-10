/*
 * Problem: 905. Sort Array By Parity
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/sort-array-by-parity/
 * Language: java
 * Date: 2026-04-10
 */

class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            while (l<r&&nums[l] % 2 == 0) {
                l++;
            }
            while (l < r&&nums[r] % 2 == 1) {
                r--;
            }
            if (l < r) {
                int tmp = nums[l];
                nums[l] = nums[r];
                nums[r] = tmp;
            }
        }
        return nums;
    }
}
