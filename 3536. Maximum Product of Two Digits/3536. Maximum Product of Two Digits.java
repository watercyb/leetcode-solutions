/*
 * Problem: 3536. Maximum Product of Two Digits
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/maximum-product-of-two-digits/?envType=daily-question&envId=2026-07-25
 * Language: java
 * Date: 2026-07-25
 */

class Solution {
    public int maxProduct(int n) {
        int[] counts = new int[10];
        while (n > 0) {
            counts[n % 10]++;
            n /= 10;
        }
        int a = 0;
        for (int i = 9; i >= 0; i--) {
            if (counts[i] > 0) {
                if (a == 0) {
                    a = i;
                    if (counts[i] > 1)
                        return i * i;
                } else {
                    return a * i;
                }
            }
        }
        return 0;
    }
}
