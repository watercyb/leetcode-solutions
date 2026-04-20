/*
 * Problem: 1748. Sum of Unique Elements
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/sum-of-unique-elements/
 * Language: java
 * Date: 2026-04-20
 */

class Solution {
    public int sumOfUnique(int[] nums) {
        int[] seens = new int[101];
        int res = 0;
        for (int num : nums) {
            if (seens[num] == 0) {
                res += num;
            } else if (seens[num] == 1) {
                res -= num;
            }
            seens[num]++;
        }
        return res;
    }
}
