/*
 * Problem: 1497. Check If Array Pairs Are Divisible by k
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/check-if-array-pairs-are-divisible-by-k/
 * Language: java
 * Date: 2026-04-17
 */

class Solution {
    public boolean canArrange(int[] arr, int k) {
        int[] counts = new int[k];
        for (int num : arr) {
            counts[(num % k + k) % k]++;
        }
        for (int i = 1; i <= (k - 1) / 2; i++) {
            if (counts[i] != counts[k - i])
                return false;
        }
        if (k % 2 == 0 && counts[k / 2] % 2 == 1)
            return false;
        return true;
    }
}
