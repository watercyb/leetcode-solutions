/*
 * Problem: 3736. Minimum Moves to Equal Array Elements III
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/minimum-moves-to-equal-array-elements-iii/
 * Language: java
 * Date: 2026-05-10
 */

class Solution {
    public int minMoves(int[] nums) {
        int sum=0;
        int max=0;
        for (int num:nums) {
            sum+=num;
            max=Math.max(max,num);
        }
        return max*nums.length-sum;
    }
}
