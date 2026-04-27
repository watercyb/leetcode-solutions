/*
 * Problem: 2498. Frog Jump II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/frog-jump-ii/
 * Language: java
 * Date: 2026-04-27
 */

class Solution {
    public int maxJump(int[] stones) {
        int res = stones[1] - stones[0];
        for (int i = 2; i < stones.length; i++) {
            res = Math.max(res, stones[i] - stones[i - 2]);
        }
        return res;
    }
}
