/*
 * Problem: 3581. Count Odd Letters from Number
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/count-odd-letters-from-number/
 * Language: java
 * Date: 2026-05-08
 */

class Solution {
    public int countOddLetters(int n) {
        int[] arr = { 16577, 97, 4672, 648, 1218, 2067, 8464, 2336, 541, 17 };
        int h = 0;
        while (n > 0) {
            h ^= arr[n % 10];
            n /= 10;
        }
        return Integer.bitCount(h);
    }
}
