/*
 * Problem: 875. Koko Eating Bananas
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/koko-eating-bananas/
 * Language: java
 * Date: 2026-04-09
 */

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        long sum = 0;
        for (int pile : piles) {
            sum += pile;
        }
        int l = (int) ((sum - 1) / h) + 1;
        int r = (int) ((sum - piles.length) / (h - piles.length + 1)) + 1;
        while (l < r) {
            int mid = (r - l) / 2 + l;
            if (chk(piles, h, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;

    }

    public boolean chk(int[] piles, int h, int speed) {
        for (int i = 0; i < piles.length; i++) {
            h -= (piles[i] - 1) / speed + 1;
        }
        return h >= 0;
    }
}
