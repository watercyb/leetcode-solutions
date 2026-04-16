/*
 * Problem: 1365. How Many Numbers Are Smaller Than the Current Number
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/
 * Language: java
 * Date: 2026-04-16
 */

class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] counts = new int[102];
        for (int num : nums) {
            counts[num + 1]++;
        }
        for (int i = 1; i <= 100; i++) {
            counts[i] += counts[i - 1];
        }
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = counts[nums[i]];
        }
        return res;
    }
}
