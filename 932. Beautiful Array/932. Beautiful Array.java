/*
 * Problem: 932. Beautiful Array
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/beautiful-array/
 * Language: java
 * Date: 2026-04-10
 */

class Solution {

    int[][] meme = new int[1001][];

    public int[] beautifulArray(int n) {
        if (meme[n] != null)
            return meme[n];
        if (n == 1)
            return meme[n] = new int[] { 1 };
        meme[n] = new int[n];
        int idx = 0;
        for (int num : beautifulArray((n + 1) / 2)) {
            meme[n][idx++] = num * 2 - 1;
        }
        for (int num : beautifulArray(n / 2)) {
            meme[n][idx++] = num * 2;
        }
        return meme[n];
    }
}
