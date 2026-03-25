/*
 * Problem: 96. Unique Binary Search Trees
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/unique-binary-search-trees/
 * Language: java
 * Date: 2026-03-25
 */

class Solution {
    public int numTrees(int n) {
        int[] DP = new int[n + 1];
        DP[0] = 1;
        DP[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; 2 * j < i; j++) {
                if (j * 2 == i - 1) {
                    DP[i] += DP[j] * DP[i - 1 - j];
                } else {
                    DP[i] += DP[j] * DP[i - 1 - j] * 2;
                }
            }
        }
        return DP[n];
    }
}
