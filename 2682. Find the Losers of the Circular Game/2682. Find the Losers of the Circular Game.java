/*
 * Problem: 2682. Find the Losers of the Circular Game
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/find-the-losers-of-the-circular-game/
 * Language: java
 * Date: 2026-04-29
 */

class Solution {
    public int[] circularGameLosers(int n, int k) {
        boolean[] seens = new boolean[n];
        seens[0] = true;
        int count = 1;
        int idx = k % n;
        int i = 1;
        while (!seens[idx]) {
            seens[idx] = true;
            count++;
            i++;
            idx = (idx + i * k) % n;
        }
        int[] res = new int[n - count];
        idx = 0;
        for (int j = 0; j < n; j++) {
            if (!seens[j])
                res[idx++] = j + 1;
        }
        return res;
    }
}
