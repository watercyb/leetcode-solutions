/*
 * Problem: 2433. Find The Original Array of Prefix Xor
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-the-original-array-of-prefix-xor/
 * Language: java
 * Date: 2026-04-27
 */

class Solution {
    public int[] findArray(int[] pref) {
        for (int i = pref.length - 1; i > 0; i--) {
            pref[i] ^= pref[i - 1];
        }
        return pref;
    }
}
