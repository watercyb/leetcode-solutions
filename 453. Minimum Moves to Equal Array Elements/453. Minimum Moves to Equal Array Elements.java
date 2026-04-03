/*
 * Problem: 453. Minimum Moves to Equal Array Elements
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-moves-to-equal-array-elements/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int num : nums) {
            if (num < min)
                min = num;
            sum += num;
        }
        return sum - nums.length * min;
    }
}
