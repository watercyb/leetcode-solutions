/*
 * Problem: 1189. Maximum Number of Balloons
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/maximum-number-of-balloons/?envType=daily-question&envId=2026-06-22
 * Language: java
 * Date: 2026-06-22
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
