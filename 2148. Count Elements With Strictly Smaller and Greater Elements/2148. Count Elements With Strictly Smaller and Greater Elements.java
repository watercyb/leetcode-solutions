/*
 * Problem: 2148. Count Elements With Strictly Smaller and Greater Elements
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/count-elements-with-strictly-smaller-and-greater-elements/
 * Language: java
 * Date: 2026-04-24
 */

class Solution {
    public int countElements(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            max = Math.max(num, max);
            min = Math.min(num, min);
        }
        int res = nums.length;
        for (int num : nums) {
            if (num == max || num == min)
                res--;
        }
        return res;
    }
}
