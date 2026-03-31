/*
 * Problem: 266. Palindrome Permutation
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/palindrome-permutation/
 * Language: java
 * Date: 2026-03-31
 */

class Solution {
    public boolean canPermutePalindrome(String s) {
        boolean[] odds = new boolean['z' + 1];
        int count = 0;
        for (char chr : s.toCharArray()) {
            odds[chr] = !odds[chr];
            if (odds[chr]) {
                count++;
            } else {
                count--;
            }
        }
        return count <= 1;
    }
}
