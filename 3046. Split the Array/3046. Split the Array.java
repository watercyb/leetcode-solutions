/*
 * Problem: 3046. Split the Array
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/split-the-array/
 * Language: java
 * Date: 2026-05-03
 */

class Solution {
    public boolean isPossibleToSplit(int[] nums) {
        int[] counts = new int[101];
        for (int num : nums) {
            if (++counts[num] == 3)
                return false;
        }
        return true;
    }
}
