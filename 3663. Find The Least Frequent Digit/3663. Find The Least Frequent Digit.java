/*
 * Problem: 3663. Find The Least Frequent Digit
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/find-the-least-frequent-digit/
 * Language: java
 * Date: 2026-05-09
 */

class Solution {
    public int getLeastFrequentDigit(int n) {
        int[] counts = new int[10];
        while (n > 0) {
            counts[n % 10]++;
            n /= 10;
        }
        int res = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > 0 && counts[i] < min) {
                min = counts[i];
                res = i;
            }
        }
        return res;
    }
}
