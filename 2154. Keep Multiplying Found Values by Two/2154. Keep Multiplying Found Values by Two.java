/*
 * Problem: 2154. Keep Multiplying Found Values by Two
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/keep-multiplying-found-values-by-two/
 * Language: java
 * Date: 2026-04-24
 */

class Solution {
    public int findFinalValue(int[] nums, int original) {
        boolean[] seens = new boolean[10001];
        for (int num : nums) {
            seens[num] = true;
        }
        while (original <= 1000 && seens[original]) {
            original *= 2;
        }
        return original;
    }
}
