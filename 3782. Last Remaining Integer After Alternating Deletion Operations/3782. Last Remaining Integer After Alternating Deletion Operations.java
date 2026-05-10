/*
 * Problem: 3782. Last Remaining Integer After Alternating Deletion Operations
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/last-remaining-integer-after-alternating-deletion-operations/
 * Language: java
 * Date: 2026-05-10
 */

class Solution {
    public long lastInteger(long n) {
        return dfs(n, true) + 1;
    }

    public long dfs(long n, boolean left) {
        if (n == 1)
            return 0;
        if (left) {
            return 2 * dfs((n + 1) / 2, !left);
        } else {
            return 2 * dfs((n + 1) / 2, !left) - (n & 1) + 1;
        }
    }
}
