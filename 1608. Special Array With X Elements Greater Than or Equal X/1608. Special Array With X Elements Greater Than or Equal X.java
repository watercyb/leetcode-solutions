/*
 * Problem: 1608. Special Array With X Elements Greater Than or Equal X
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/special-array-with-x-elements-greater-than-or-equal-x/
 * Language: java
 * Date: 2026-04-19
 */

class Solution {
    public int specialArray(int[] nums) {
        int[] counts = new int[nums.length + 2];
        for (int num : nums) {
            if (num > nums.length)
                num = nums.length;
            counts[num]++;
        }
        for (int i = nums.length; i >= 0; i--) {
            counts[i] += counts[i + 1];
            if (counts[i] == i)
                return i;
        }
        return -1;
    }
}
