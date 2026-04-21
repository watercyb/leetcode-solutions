/*
 * Problem: 1884. Egg Drop With 2 Eggs and N Floors
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/egg-drop-with-2-eggs-and-n-floors/
 * Language: java
 * Date: 2026-04-21
 */

class Solution {
    static int[] meme = new int[10001];

    public int twoEggDrop(int n) {
        if (n <= 2)
            return n;
        if (meme[n] != 0)
            return meme[n];
        int res = Integer.MAX_VALUE;
        for (int i = 1; i < n && i < res; i++) {
            res = Math.min(Math.max(i - 1, twoEggDrop(n - i)) + 1, res);
        }
        return meme[n] = res;
    }
}
