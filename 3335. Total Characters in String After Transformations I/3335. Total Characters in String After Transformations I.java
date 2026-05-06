/*
 * Problem: 3335. Total Characters in String After Transformations I
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/total-characters-in-string-after-transformations-i/
 * Language: java
 * Date: 2026-05-06
 */

class Solution {
    public int lengthAfterTransformations(String s, int t) {
        int mod = 1_000_000_007;
        int[] counts = new int[26];
        for (char chr : s.toCharArray()) {
            counts[chr - 'a']++;
        }
        while (t >= 26) {
            counts[0] = (counts[0] + counts[25]) % mod;
            for (int i = 24; i >= 0; i--) {
                counts[i + 1] = (counts[i + 1] + counts[i]) % mod;
            }
            t -= 26;
        }
        long res = 0;
        for (int i = 0; i <= 25; i++) {
            if (i + t >= 26) {
                res = (res + 2l * counts[i]) % mod;
            } else {
                res = (res + counts[i]) % mod;
            }
        }
        return (int) res;
    }
}
