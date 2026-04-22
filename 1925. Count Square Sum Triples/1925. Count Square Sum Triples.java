/*
 * Problem: 1925. Count Square Sum Triples
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/count-square-sum-triples/
 * Language: java
 * Date: 2026-04-22
 */

class Solution {
    public int countTriples(int n) {
        int res = 0;
        int lim = (int) Math.sqrt(n * n);
        for (int i = 1; i <= lim; i++) {
            int count = 0;
            for (int j = 1; j <= n - i; j++) {
                count += (i + j) * 2 - 1;
                if (Math.pow((int) Math.sqrt(count), 2) == count) {
                    res++;
                }
            }
        }
        return res;
    }
}
