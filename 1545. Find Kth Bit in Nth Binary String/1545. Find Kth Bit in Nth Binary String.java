/*
 * Problem: 1545. Find Kth Bit in Nth Binary String
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-kth-bit-in-nth-binary-string/
 * Language: java
 * Date: 2026-04-18
 */

class Solution {
    public char findKthBit(int n, int k) {
        int length = 1;
        for (int i = 0; i < n - 1; i++) {
            length = length * 2 + 1;
        }
        int count = dfs(length, n, k);
        if (count == 1)
            return (char) (res % 2 + '0');
        return (char) ('1' - res % 2);
    }

    int res = 0;

    public int dfs(int length, int n, int k) {
        int a = length + 1 - k;
        if (k == a)
            return n;
        if (k > a) {
            k = a;
            res++;
        }
        return dfs(length / 2, n - 1, k);
    }
}
