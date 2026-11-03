/*
 * Problem: 4100. Minimum Cost Path With Even XOR Parity
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimum-cost-path-with-even-xor-parity/
 * Language: java
 * Date: 2026-11-03
 */

class Solution {
    public int minActivationCost(int[][] edges, int[] values) {
        for (int i = 0; i < values.length; i++) {
            values[i] = Integer.bitCount(values[i]) & 1;
        }
        int[] pairs = new int[values.length];
        Arrays.fill(pairs, -1);
        int res = Integer.MAX_VALUE;
        for (int[] edge : edges) {
            int l = edge[0];
            int r = edge[1];
            int c = edge[2];
            int v = values[l] ^ values[r];
            if (v == 0 && edge[2] < res) {
                res = edge[2];
            } else {
                if (values[l] == 1) {
                    int temp = l;
                    l = r;
                    r = l;
                }
                if (pairs[l] == -1) {
                    pairs[l] = c;
                } else {
                    res = Math.min(res, c + pairs[l]);
                    pairs[l] = Math.min(pairs[l], c);
                }
            }
        }
        if (res != Integer.MAX_VALUE)
            return res;
        return -1;
    }
}
