/*
 * Problem: 3792. Sum of Increasing Product Blocks
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/sum-of-increasing-product-blocks/
 * Language: java
 * Date: 2026-05-10
 */

class Solution {
    public int sumOfBlocks(int n) {
        int mod = 1_000_000_007;
        long res = 1;
        int idx = 2;
        for (int i = 2; i <= n; i++) {
            long num = 1;
            for (int j = 0; j < i; j++) {
                num = (num * idx) % mod;
                idx++;
            }
            res += num;
        }
        return (int) (res % mod);
    }
}
