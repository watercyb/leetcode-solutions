/*
 * Problem: 2445. Number of Nodes With Value One
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/number-of-nodes-with-value-one/
 * Language: java
 * Date: 2026-04-27
 */

class Solution {
    public int numberOfNodes(int n, int[] queries) {
        int[] arr = new int[n + 1];
        for (int query : queries) {
            arr[query] = 1 - arr[query];
        }
        int res = 0;
        for (int i = 1; i <= n; i++) {
            arr[i] ^= arr[i / 2];
            res += arr[i];
        }
        return res;
    }
}
