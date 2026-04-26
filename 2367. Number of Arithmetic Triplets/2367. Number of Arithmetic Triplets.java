/*
 * Problem: 2367. Number of Arithmetic Triplets
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/number-of-arithmetic-triplets/
 * Language: java
 * Date: 2026-04-26
 */

class Solution {
    public int arithmeticTriplets(int[] nums, int diff) {
        int[] counts1 = new int[201];
        int[] counts2 = new int[201];
        int res = 0;
        for (int num : nums) {
            if (num - diff >= 0) {
                res += counts2[num - diff];
                counts2[num] += counts1[num - diff];
            }
            counts1[num]++;
        }
        return res;
    }
}
