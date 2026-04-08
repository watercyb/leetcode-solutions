/*
 * Problem: 779. K-th Symbol in Grammar
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/k-th-symbol-in-grammar/
 * Language: java
 * Date: 2026-04-08
 */

class Solution {
    public int kthGrammar(int n, int k) {
        return kth(n, k - 1);
    }

    public int kth(int n, int k) {
        if (n == 1)
            return 0;
        return kth(n - 1, k / 2) ^ (k % 2);
    }
}
