/*
 * Problem: 3679.  Minimum Discards to Balance Inventory
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-discards-to-balance-inventory/
 * Language: java
 * Date: 2026-05-09
 */

class Solution {
    public int minArrivalsToDiscard(int[] arrivals, int w, int m) {
        int max = 0;
        for (int arrival : arrivals) {
            max = Math.max(max, arrival);
        }
        int[] counts = new int[max + 1];
        int j = 0;
        int res = 0;
        for (int i = 0; j < arrivals.length; i++) {
            while (j < arrivals.length && j - i < w) {
                if (counts[arrivals[j]] == m) {
                    res++;
                    arrivals[j] = 0;
                } else {
                    counts[arrivals[j]]++;
                }
                j++;
            }
            counts[arrivals[i]]--;
        }
        return res;
    }
}
