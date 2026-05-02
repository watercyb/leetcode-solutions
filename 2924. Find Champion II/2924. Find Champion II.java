/*
 * Problem: 2924. Find Champion II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-champion-ii/
 * Language: java
 * Date: 2026-05-02
 */

class Solution {
    public int findChampion(int n, int[][] edges) {
        boolean[] seens = new boolean[n];
        int count = n;
        for (int[] edge : edges) {
            if (!seens[edge[1]]) {
                seens[edge[1]] = true;
                count--;
            }
        }
        if (count != 1)
            return -1;
        for (int i = 0; i < n; i++) {
            if (!seens[i]) {
                return i;
            }
        }
        return -1;
    }
}
