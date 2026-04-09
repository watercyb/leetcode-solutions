/*
 * Problem: 821. Shortest Distance to a Character
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/shortest-distance-to-a-character/
 * Language: java
 * Date: 2026-04-09
 */

class Solution {
    public int[] shortestToChar(String s, char c) {
        char[] chrs = s.toCharArray();
        int[] res = new int[chrs.length];
        int distance = Integer.MAX_VALUE / 2;
        for (int i = 0; i < chrs.length; i++) {
            if (chrs[i] == c)
                distance = 0;
            res[i] = distance;
            distance++;
        }
        distance = Integer.MAX_VALUE / 2;
        for (int i = chrs.length - 1; i >= 0; i--) {
            if (chrs[i] == c)
                distance = 0;
            res[i] = Math.min(distance, res[i]);
            distance++;
        }
        return res;
    }
}
