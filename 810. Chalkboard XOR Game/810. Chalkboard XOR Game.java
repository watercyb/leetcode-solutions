/*
 * Problem: 810. Chalkboard XOR Game
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/chalkboard-xor-game/
 * Language: java
 * Date: 2026-04-09
 */

class Solution {
    public boolean xorGame(int[] nums) {
        if (nums.length % 2 == 0)
            return true;
        int XOR = 0;
        for (int num : nums) {
            XOR ^= num;
        }
        return XOR == 0;
    }
}
