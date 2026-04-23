/*
 * Problem: 2029. Stone Game IX
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/stone-game-ix/
 * Language: java
 * Date: 2026-04-23
 */

class Solution {
    public boolean stoneGameIX(int[] stones) {
        int[] counts = new int[3];
        for (int stone : stones) {
            counts[stone % 3]++;
        }
        if (counts[1] == 0 || counts[2] == 0) {
            if (counts[1] > 2 || counts[2] > 2)
                return counts[0] % 2 == 1;
            return false;
        }
        if (Math.abs(counts[1] - counts[2]) <= 2)
            return counts[0] % 2 == 0;
        return true;
    }
}
