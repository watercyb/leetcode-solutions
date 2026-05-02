/*
 * Problem: 2939. Maximum Xor Product
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-xor-product/
 * Language: java
 * Date: 2026-05-02
 */

class Solution {
    public int maximumXorProduct(long a, long b, int n) {
        int mod = 1_000_000_007;
        long numA = a >> n;
        long numB = b >> n;
        for (int i = n - 1; i >= 0; i--) {
            long base = 1l << i;
            numA *= 2;
            numB *= 2;
            if ((a & base) == (b & base)) {
                numA++;
                numB++;
            } else if (numA > numB) {
                numB++;
            } else {
                numA++;
            }
        }
        return (int) ((numA % mod) * (numB % mod) % mod);
    }
}
