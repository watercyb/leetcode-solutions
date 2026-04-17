/*
 * Problem: 1478. Allocate Mailboxes
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/allocate-mailboxes/
 * Language: java
 * Date: 2026-04-17
 */

class Solution {
    public int minDistance(int[] houses, int k) {
        Arrays.sort(houses);
        return dfs(houses, new int[houses.length][k + 1], 0, k) - 1;
    }

    public int dfs(int[] houses, int[][] meme, int i, int k) {
        if (meme[i][k] != 0)
            return meme[i][k];
        if (k == 1) {
            return meme[i][k] = getDistance(houses, i, houses.length - 1) + 1;
        } else {
            int res = dfs(houses, meme, i + 1, k - 1);
            for (int j = i + 1; j <= houses.length - k; j++) {
                res = Math.min(dfs(houses, meme, j + 1, k - 1) + getDistance(houses, i, j), res);
            }
            return meme[i][k] = res;
        }
    }

    public int getDistance(int[] houses, int i, int j) {
        int res = 0;
        while (i < j) {
            res += houses[j] - houses[i];
            i++;
            j--;
        }
        return res;
    }
}
