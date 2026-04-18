/*
 * Problem: 1561. Maximum Number of Coins You Can Get
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-number-of-coins-you-can-get/
 * Language: java
 * Date: 2026-04-18
 */

class Solution {
    public int maxCoins(int[] piles) {
        int[] counts = new int[10001];
        for (int pile : piles) {
            counts[pile]++;
        }
        int idx = 10000;
        int res = 0;
        for (int i = 0; i < piles.length / 3; i++) {
            while (counts[idx] == 0)
                idx--;
            counts[idx]--;
            while (counts[idx] == 0)
                idx--;
            res+=idx;
            counts[idx]--;
        }
        return res;
    }
}
