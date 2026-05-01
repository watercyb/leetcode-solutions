/*
 * Problem: 2806. Account Balance After Rounded Purchase
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/account-balance-after-rounded-purchase/
 * Language: java
 * Date: 2026-05-01
 */

class Solution {
    public int accountBalanceAfterPurchase(int purchaseAmount) {
        if (purchaseAmount % 10 >= 5) {
            purchaseAmount = (purchaseAmount / 10 + 1) * 10;
        } else {
            purchaseAmount = (purchaseAmount / 10) * 10;
        }
        return 100 - purchaseAmount;
    }
}
