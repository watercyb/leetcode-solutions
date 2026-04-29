/*
 * Problem: 2683. Neighboring Bitwise XOR
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/neighboring-bitwise-xor/
 * Language: java
 * Date: 2026-04-29
 */

class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int num = 0;
        for (int i = 0; i < derived.length; i++) {
            num ^= derived[i];
        }
        return num == 0;
    }
}
