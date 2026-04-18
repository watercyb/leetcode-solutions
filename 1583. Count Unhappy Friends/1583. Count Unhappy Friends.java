/*
 * Problem: 1583. Count Unhappy Friends
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/count-unhappy-friends/
 * Language: java
 * Date: 2026-04-18
 */

class Solution {
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        int[] p = new int[n];
        for (int i = 0; i < pairs.length; i++) {
            p[pairs[i][0]] = pairs[i][1];
            p[pairs[i][1]] = pairs[i][0];
        }
        int res = 0;
        for (int i = 0; i < pairs.length; i++) {
            if (chk(preferences, p, pairs[i][0], pairs[i][1]))
                res++;
            if (chk(preferences, p, pairs[i][1], pairs[i][0]))
                res++;
        }

        return res;
    }

    public boolean chk(int[][] preferences, int[] p, int a, int b) {
        for (int c : preferences[a]) {
            if (c == b)
                break;
            for (int d : preferences[c]) {
                if (d == p[c])
                    break;
                if (d == a)
                    return true;
            }
        }
        return false;
    }
}
