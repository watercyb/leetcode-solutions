/*
 * Problem: 1281. Subtract the Product and Sum of Digits of an Integer
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/
 * Language: java
 * Date: 2026-04-15
 */

class Solution {
    public int subtractProductAndSum(int n) {
        int pro = 1;
        int sum = 0;
        while (n > 0) {
            int mod = n % 10;
            pro *= mod;
            sum += mod;
            n /= 10;
        }
        return pro - sum;
    }
}
