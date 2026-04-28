/*
 * Problem: 2511. Maximum Enemy Forts That Can Be Captured
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/maximum-enemy-forts-that-can-be-captured/
 * Language: java
 * Date: 2026-04-28
 */

class Solution {
    public int captureForts(int[] forts) {
        int res = 0;
        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;
        for (int i = 0; i < forts.length; i++) {
            if (forts[i] == -1) {
                res = Math.max(res, i - b - 1);
                a = i;
                b = Integer.MAX_VALUE;
            } else if (forts[i] == 1) {
                res = Math.max(res, i - a - 1);
                b = i;
                a = Integer.MAX_VALUE;
            }
        }
        return res;
    }
}
