/*
 * Problem: 2160. Minimum Sum of Four Digit Number After Splitting Digits
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/minimum-sum-of-four-digit-number-after-splitting-digits/
 * Language: java
 * Date: 2026-04-24
 */

class Solution {
    public int minimumSum(int num) {
        int[] counts = new int[10];
        while (num > 0) {
            counts[num % 10]++;
            num /= 10;
        }
        int[] pair = new int[2];
        int idx = 0;
        for (int i = 1; i < 10; i++) {
            while (counts[i] > 0) {
                pair[idx] = pair[idx] * 10 + i;
                counts[i]--;
                idx = 1 - idx;
            }
        }
        return pair[0] + pair[1];
    }
}
