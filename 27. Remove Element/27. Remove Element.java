/*
 * Problem: 27. Remove Element
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/remove-element/
 * Language: java
 * Date: 2026-03-25
 */

class Solution {
    public int removeElement(int[] nums, int val) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                if (j<=i) j=i+1;
                while (j < nums.length && nums[j] == val) {
                    j++;
                }
                if (j==nums.length) return i;
                nums[i]=nums[j];
                nums[j]=val;
                j++;
            }
        }
        return nums.length;
    }
}
