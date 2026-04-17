/*
 * Problem: 1486. XOR Operation in an Array
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/xor-operation-in-an-array/
 * Language: java
 * Date: 2026-04-17
 */

class Solution {
    public int xorOperation(int n, int start) {
        int res = 0;
        for (int i = 0; i < n; i++) {
            res ^= start + 2 * i;
        }
        return res;
    }
}
