/*
 * Problem: 822. Card Flipping Game
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/card-flipping-game/
 * Language: java
 * Date: 2026-04-09
 */

class Solution {
    public int flipgame(int[] fronts, int[] backs) {
        int[] arr = new int[2001];
        for (int i = 0; i < fronts.length; i++) {
            if (fronts[i] == backs[i]) {
                arr[fronts[i]] = Integer.MIN_VALUE;
            } else {
                arr[fronts[i]]++;
                arr[backs[i]]++;
            }
        }
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > 0)
                return i;
        }
        return 0;
    }
}
