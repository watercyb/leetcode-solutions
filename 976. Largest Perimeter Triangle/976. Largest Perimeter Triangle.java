/*
 * Problem: 976. Largest Perimeter Triangle
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/largest-perimeter-triangle/
 * Language: java
 * Date: 2026-04-10
 */

class Solution {
    public int largestPerimeter(int[] nums) {
        sort(nums, 0);
        sort(nums, 1);
        for (int i = 2; i < nums.length; i++) {
            sort(nums, i);
            if (nums[i - 2] < nums[i - 1] + nums[i])
                return nums[i] + nums[i - 1] + nums[i - 2];
        }
        return 0;
    }

    public void sort(int[] nums, int i) {
        int k = nums.length - 1;
        for (int j = nums.length - 2; j >= i; j--) {
            if (nums[k] < nums[j]) {
                k = j;
            }
        }
        int tmp = nums[i];
        nums[i] = nums[k];
        nums[k] = tmp;
    }
}
