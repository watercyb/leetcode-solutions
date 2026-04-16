/*
 * Problem: 1310. XOR Queries of a Subarray
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/xor-queries-of-a-subarray/
 * Language: java
 * Date: 2026-04-16
 */

class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] xor = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            xor[i + 1] = xor[i] ^ arr[i];
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            res[i] = xor[queries[i][1] + 1] ^ xor[queries[i][0]];
        }
        return res;
    }
}
