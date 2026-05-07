/*
 * Problem: 3438. Find Valid Pair of Adjacent Digits in String
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/find-valid-pair-of-adjacent-digits-in-string/
 * Language: java
 * Date: 2026-05-07
 */

class Solution {
    public String findValidPair(String s) {
        int[] counts = new int[10];
        for (int i = 0; i < s.length(); i++) {
            int j = s.charAt(i) - '0';
            counts[j]++;
        }
        for (int i = 1; i < s.length(); i++) {
            int a = s.charAt(i - 1) - '0';
            int b = s.charAt(i) - '0';
            if (counts[a] == a && counts[b] == b && a != b)
                return new StringBuilder().append(a).append(b).toString();
        }
        return "";
    }
}
