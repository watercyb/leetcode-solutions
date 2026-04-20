/*
 * Problem: 1734. Decode XORed Permutation
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/decode-xored-permutation/
 * Language: java
 * Date: 2026-04-20
 */

class Solution {
    public int[] decode(int[] encoded) {
        int XOR = 0;
        for (int i = 1; i <= encoded.length + 1; i++) {
            XOR ^= i;
        }
        for (int i = 1; i < encoded.length; i += 2) {
            XOR ^= encoded[i];
        }
        int[] res = new int[encoded.length + 1];
        res[0] = XOR;
        for (int i = 0; i < encoded.length; i++) {
            XOR ^= encoded[i];
            res[i + 1] = XOR;
        }
        return res;
    }
}
