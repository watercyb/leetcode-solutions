/*
 * Problem: 2582. Pass the Pillow
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/pass-the-pillow/
 * Language: java
 * Date: 2026-04-28
 */

class Solution {
    public int passThePillow(int n, int time) {
        int res = time % ((n - 1) * 2) + 1;
        if (res > n)
            return 2 * n - res;
        return res;
    }
}
