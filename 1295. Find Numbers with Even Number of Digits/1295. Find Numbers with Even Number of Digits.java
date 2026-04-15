/*
 * Problem: 1295. Find Numbers with Even Number of Digits
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/find-numbers-with-even-number-of-digits/
 * Language: java
 * Date: 2026-04-15
 */

class Solution {
    public int findNumbers(int[] nums) {
        int res = 0;
        for (int num : nums) {
            if ((int) Math.log10(num) % 2 == 1)
                res++;
        }
        return res;
    }
}
