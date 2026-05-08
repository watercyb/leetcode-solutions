/*
 * Problem: 3545. Minimum Deletions for At Most K Distinct Characters
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/minimum-deletions-for-at-most-k-distinct-characters/
 * Language: java
 * Date: 2026-05-08
 */

class Solution {
    public int minDeletion(String s, int k) {
        int[] counts = new int[26];
        for (char chr : s.toCharArray()) {
            counts[chr - 'a']++;
        }
        Arrays.sort(counts);
        int idx = 0;
        while (counts[idx] == 0) {
            idx++;
        }
        int res = 0;
        while (26 - idx > k) {
            res += counts[idx++];
        }
        return res;
    }
}
