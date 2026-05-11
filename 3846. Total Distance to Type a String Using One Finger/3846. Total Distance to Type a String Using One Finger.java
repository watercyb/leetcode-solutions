/*
 * Problem: 3846. Total Distance to Type a String Using One Finger
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/total-distance-to-type-a-string-using-one-finger/
 * Language: java
 * Date: 2026-05-11
 */

class Solution {
    public int totalDistance(String s) {
        char[][] chrs = { { 'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p' },
                { 'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l' },
                { 'z', 'x', 'c', 'v', 'b', 'n', 'm' } };
        int[][] positions = new int[26][2];
        for (int i = 0; i < chrs.length; i++) {
            for (int j = 0; j < chrs[i].length; j++) {
                positions[chrs[i][j] - 'a'] = new int[] { i, j };
            }
        }
        int res = 0;
        int prv = 0;
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            res += getDist(positions[prv], positions[idx]);
            prv = idx;
        }
        return res;
    }

    public int getDist(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
}
