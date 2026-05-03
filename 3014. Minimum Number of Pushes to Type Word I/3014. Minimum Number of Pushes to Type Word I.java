/*
 * Problem: 3014. Minimum Number of Pushes to Type Word I
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/minimum-number-of-pushes-to-type-word-i/
 * Language: java
 * Date: 2026-05-03
 */

class Solution {
    public int minimumPushes(String word) {
        int n = word.length();
        int t = 1;
        int res = 0;
        while (n > 8) {
            res += t * 8;
            n -= 8;
            t++;
        }
        return res + t * n;
    }
}
