/*
 * Problem: 3096. Minimum Levels to Gain More Points
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-levels-to-gain-more-points/
 * Language: java
 * Date: 2026-05-03
 */

class Solution {
    public int minimumLevels(int[] possible) {
        int total = 0;
        for (int num : possible) {
            total += num * 2 - 1;
        }
        int sum = 0;
        for (int i = 0; i < possible.length - 1; i++) {
            sum += possible[i] * 2 - 1;
            if (2 * sum - total > 0)
                return i + 1;
        }
        return -1;
    }
}
