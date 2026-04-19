/*
 * Problem: 1686. Stone Game VI
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/stone-game-vi/
 * Language: java
 * Date: 2026-04-19
 */

class Solution {
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        int[] counts = new int[201];
        int sum = 0;
        for (int i = 0; i < aliceValues.length; i++) {
            sum += aliceValues[i] - bobValues[i];
            counts[aliceValues[i] + bobValues[i]]++;
        }
        int p = 1;
        for (int i = counts.length - 1; i >= 0; i--) {
            while (counts[i] > 0) {
                sum += p * i;
                p = -p;
                counts[i]--;
            }
        }
        return Integer.compare(sum, 0);
    }
}
