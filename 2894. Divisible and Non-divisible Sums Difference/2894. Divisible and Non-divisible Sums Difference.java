/*
 * Problem: 2894. Divisible and Non-divisible Sums Difference
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/divisible-and-non-divisible-sums-difference/
 * Language: java
 * Date: 2026-05-01
 */

class Solution {
    public int differenceOfSums(int n, int m) {
        return (n + 1) * n / 2 - (n / m + 1) * (n / m) * m;
    }
}
