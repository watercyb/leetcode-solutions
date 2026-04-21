/*
 * Problem: 1835. Find XOR Sum of All Pairs Bitwise AND
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/find-xor-sum-of-all-pairs-bitwise-and/
 * Language: java
 * Date: 2026-04-21
 */

class Solution {
    public int getXORSum(int[] arr1, int[] arr2) {
        return getXOR(arr1)&getXOR(arr2);
    }

    public int getXOR(int[] arr) {
        int res = 0;
        for (int num : arr) {
            res ^= num;
        }
        return res;
    }
}
