/*
 * Problem: 1-bit and 2-bit Characters
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/1-bit-and-2-bit-characters/
 * Language: java
 * Date: 2026-04-08
 */

class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int count = 0;
        for (int i = 0; i < bits.length - 1; i++) {
            if (bits[i] == 1) {
                count++;
            } else {
                count = 0;
            }
        }
        return count % 2 == 0;
    }
}
