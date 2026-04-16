/*
 * Problem: 1356. Sort Integers by The Number of 1 Bits
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/sort-integers-by-the-number-of-1-bits/
 * Language: java
 * Date: 2026-04-16
 */

class Solution {
    public int[] sortByBits(int[] arr) {
        int max = 0;
        for (int num : arr) {
            max = Math.max(num, max);
        }
        int[] counts = new int[max + 1];
        int[] countBits = new int[30];
        for (int num : arr) {
            counts[num]++;
            countBits[Integer.bitCount(num)]++;
        }
        for (int i = 1; i < countBits.length; i++) {
            countBits[i] += countBits[i - 1];
        }
        for (int i = max; i >= 0; i--) {
            int count = Integer.bitCount(i);
            for (int j = 0; j < counts[i]; j++) {
                arr[--countBits[count]] = i;
            }
        }
        return arr;
    }
}
