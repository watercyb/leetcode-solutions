/*
 * Problem: 2399. Check Distances Between Same Letters
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/check-distances-between-same-letters/
 * Language: java
 * Date: 2026-04-26
 */

class Solution {
    public boolean checkDistances(String s, int[] distance) {
        int[] distances = new int[26];
        Arrays.fill(distances, -1);
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            if (distances[idx] == -1) {
                distances[idx] = i;
            } else {
                if (distance[idx] != i - distances[idx] - 1)
                    return false;
            }
        }
        return true;
    }
}
