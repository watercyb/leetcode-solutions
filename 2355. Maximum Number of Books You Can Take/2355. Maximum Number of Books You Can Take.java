/*
 * Problem: 2355. Maximum Number of Books You Can Take
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/maximum-number-of-books-you-can-take/
 * Language: java
 * Date: 2026-04-26
 */

class Solution {
    public long maximumBooks(int[] books) {
        int[] MQ = new int[books.length];
        int idx = 1;
        long[] DP = new long[books.length];
        DP[0] = books[0];
        long res = books[0];
        for (int i = 1; i < books.length; i++) {
            while (idx > 0 && books[i] <= books[MQ[idx - 1]]) {
                idx--;
            }
            MQ[idx++] = i;
            if (books[i] > books[i - 1]) {
                DP[i] = books[i] + DP[i - 1];
            } else {
                int k = idx - 2;
                while (k >= 0 && MQ[k] >= i - books[i] && books[i] - (i - MQ[k] - 1) <= books[MQ[k]]) {
                    k--;
                }
                if (k < 0 || MQ[k] < i - books[i]) {
                    int l = Math.max(i - books[i], 0) - 1;
                    DP[i] = ((long) books[i] + books[i] - (i - l - 1)) * (i - l) / 2;
                } else {
                    DP[i] = ((long) books[i] + books[i] - (i - MQ[k] - 1)) * (i - MQ[k]) / 2 + DP[MQ[k]];
                }
            }
            res = Math.max(DP[i], res);
        }
        return res;
    }
}
