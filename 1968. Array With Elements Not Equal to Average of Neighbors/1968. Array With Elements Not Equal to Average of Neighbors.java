/*
 * Problem: 1968. Array With Elements Not Equal to Average of Neighbors
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/array-with-elements-not-equal-to-average-of-neighbors/
 * Language: java
 * Date: 2026-04-22
 */

class Solution {
    public int[] rearrangeArray(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if ((i & 1) == 0) {
                if (nums[i] > nums[i + 1])
                    swap(nums, i);
            } else if (nums[i] < nums[i + 1]) {
                swap(nums, i);
            }
        }
        return nums;
    }

    public void swap(int[] nums, int i) {
        int temp=nums[i];
       nums[i]= nums[i+1];
       nums[i+1]=temp;
    }
}
