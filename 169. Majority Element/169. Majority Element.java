/*
 * Problem: 169. Majority Element
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/majority-element/
 * Language: java
 * Date: 2026-03-26
 */

class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[idx] == nums[i]) {
                count++;
            } else {
                count--;
            }
            if (count == -1) {
                idx = i;
                count = 1;
            }
        }
        return nums[idx];
    }
}
