/*
 * Problem: 1340. Jump Game V
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/jump-game-v/
 * Language: java
 * Date: 2026-04-16
 */

class Solution {
    public int maxJumps(int[] arr, int d) {
        int[][] links = new int[arr.length][2];
        for (int[] row : links) {
            Arrays.fill(row, -1);
        }
        int[] MQ = new int[arr.length + 1];
        MQ[0] = -1;
        int idx = 1;
        for (int i = 0; i < arr.length; i++) {
            while (idx > 1 && arr[MQ[idx - 1]] <= arr[i]) {
                idx--;
            }
            if (i - MQ[idx - 1] <= d)
                links[i][0] = MQ[idx - 1];
            MQ[idx++] = i;
        }
        MQ = new int[arr.length + 1];
        MQ[0] = -1;
        idx = 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            while (idx > 1 && arr[MQ[idx - 1]] <= arr[i]) {
                idx--;
            }
            if (MQ[idx - 1] - i <= d) {
                if (links[i][0] != -1) {
                    links[i][1] = MQ[idx - 1];
                } else {
                    links[i][0] = MQ[idx - 1];
                }
            }
            MQ[idx++] = i;
        }
        int[] meme = new int[arr.length];
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            res = Math.max(dfs(links, meme, i), res);
        }
        return res;
    }

    public int dfs(int[][] links, int[] meme, int i) {
        if (meme[i] != 0)
            return meme[i];
        int res = 0;
        if (links[i][0] != -1) {
            res = dfs(links, meme, links[i][0]);
            if (links[i][1] != -1) {
                res = Math.max(dfs(links, meme, links[i][1]), res);
            }
        }
        return meme[i] = res + 1;
    }
}
