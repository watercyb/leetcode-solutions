/*
 * Problem: 1406. Stone Game III
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/stone-game-iii/
 * Language: java
 * Date: 2026-04-17
 */

class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int DP1 = 0;
        int DP2 = 0;
        int DP3 = 0;
        int sum = 0;
        for (int i = 0; i < stoneValue.length; i++) {
            sum += stoneValue[stoneValue.length - 1 - i];
            int DPNext = sum - Math.min(Math.min(DP1, DP2), DP3);
            DP1 = DP2;
            DP2 = DP3;
            DP3 = DPNext;
        }
        // System.out.println(Arrays.toString(DP));
        int count = 2 * DP3;
        if (count > sum) {
            return "Alice";
        } else if (count < sum) {
            return "Bob";
        } else {
            return "Tie";
        }
    }
}
