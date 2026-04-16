/*
 * Problem: 1359. Count All Valid Pickup and Delivery Options
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/count-all-valid-pickup-and-delivery-options/
 * Language: java
 * Date: 2026-04-16
 */

class Solution {
    public int countOrders(int n) {
        int mod = 1_000_000_007;
        long res = 1;
        for (int i = 1; i <= 2 * n - 1; i += 2) {
            res = res * (1 + i) * i / 2 % mod;
        }
        return (int) res;
    }
}
