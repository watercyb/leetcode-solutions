/*
 * Problem: 546. Remove Boxes
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/remove-boxes/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public int removeBoxes(int[] boxes) {
        return dfs(boxes, new int[boxes.length][boxes.length][boxes.length], 0, boxes.length - 1, 0);
    }

    public int dfs(int[] boxes, int[][][] meme, int i, int j, int k) {
        if (i > j)
            return 0;
        if (meme[i][j][k] != 0)
            return meme[i][j][k];
        if (i == j)
            return meme[i][j][k] = (k + 1) * (k + 1);
        int j1 = j;
        int k1 = k;
        while (j > i && boxes[j - 1] == boxes[j]) {
            k++;
            j--;
        }
        int res = dfs(boxes, meme, i, j - 1, 0) + (k + 1) * (k + 1);
        for (int l = j - 1; l >= i; l--) {
            if (boxes[l] == boxes[j]) {
                res = Math.max(dfs(boxes, meme, i, l, k + 1) + dfs(boxes, meme, l + 1, j - 1, 0), res);
            }
        }
        return meme[i][j1][k1] = res;
    }
}
