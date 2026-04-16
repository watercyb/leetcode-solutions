/*
 * Problem: 1349. Maximum Students Taking Exam
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/maximum-students-taking-exam/
 * Language: java
 * Date: 2026-04-16
 */

class Solution {
    public int maxStudents(char[][] seats) {
        int[] s = new int[seats.length];
        for (int i = 0; i < seats.length; i++) {
            int h = 0;
            for (int j = 0; j < seats[0].length; j++) {
                if (seats[i][j] == '.')
                    h += 1 << j;
            }
            s[i] = h;
        }
        return dfs(s, new int[seats.length][1 << seats[0].length], 0, 0);
    }

    public int dfs(int[] s, int[][] meme, int i, int h) {
        if (i == s.length)
            return 0;
        if (meme[i][h] != 0)
            return meme[i][h];
        int res = 0;
        for (int j = 0; j < meme[0].length; j++) {
            if ((j | s[i]) != s[i] || (j & (j << 1)) != 0 || (h & (j << 1)) != 0 || (h & (j >> 1)) != 0)
                continue;
            res = Math.max(dfs(s, meme, i + 1, j) + Integer.bitCount(j), res);
        }
        return meme[i][h] = res;
    }
}
