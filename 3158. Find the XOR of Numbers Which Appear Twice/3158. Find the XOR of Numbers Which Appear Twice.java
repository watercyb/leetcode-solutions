/*
 * Problem: 3158. Find the XOR of Numbers Which Appear Twice
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/find-the-xor-of-numbers-which-appear-twice/
 * Language: java
 * Date: 2026-05-04
 */

class Solution {
    public int duplicateNumbersXOR(int[] nums) {
        boolean[] seens = new boolean[51];
        int res = 0;
        for (int num : nums) {
            if (!seens[num]) {
                seens[num] = true;
            } else {
                res ^= num;
            }
        }
        return res;
    }
}
