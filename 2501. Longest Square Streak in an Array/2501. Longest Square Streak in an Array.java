/*
 * Problem: 2501. Longest Square Streak in an Array
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/longest-square-streak-in-an-array/
 * Language: java
 * Date: 2026-04-27
 */

class Solution {
    public int longestSquareStreak(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(num, max);
        }
        boolean[] seens = new boolean[max + 1];
        for (int num : nums) {
            seens[num] = true;
        }
        int res = 0;
        for (int i = 2; i * i <= max; i++) {
            if (!seens[i])
                continue;
            seens[i] = false;
            int count = 1;
            for (int j = i * i; j <= max && j > 0; j *= j) {
                if (seens[j]) {
                    seens[j] = false;
                    count++;
                    res = Math.max(count, res);
                } else {
                    count = 0;
                }
            }
        }
        if (res <= 1)
            return -1;
        return res;
    }
}
