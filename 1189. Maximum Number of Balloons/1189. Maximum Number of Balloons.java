/*
 * Problem: 1189. Maximum Number of Balloons
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/maximum-number-of-balloons/
 * Language: java
 * Date: 2026-04-14
 */

class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] counts = new int[26];
        for (char chr : text.toCharArray()) {
            counts[chr - 'a']++;
        }
        int res = Integer.MAX_VALUE;
        res = Math.min(res, counts['b' - 'a']);
        res = Math.min(res, counts['a' - 'a']);
        res = Math.min(res, counts['l' - 'a'] / 2);
        res = Math.min(res, counts['o' - 'a'] / 2);
        res = Math.min(res, counts['n' - 'a']);
        return res;
    }
}
