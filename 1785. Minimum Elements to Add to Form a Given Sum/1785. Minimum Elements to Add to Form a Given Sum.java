/*
 * Problem: 1785. Minimum Elements to Add to Form a Given Sum
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-elements-to-add-to-form-a-given-sum/
 * Language: java
 * Date: 2026-04-20
 */

class Solution {
    public int minElements(int[] nums, int limit, int goal) {
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return (int) ((Math.abs(goal - sum) + limit - 1) / limit);
    }
}
