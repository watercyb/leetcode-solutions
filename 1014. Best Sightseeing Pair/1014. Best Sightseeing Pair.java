/*
 * Problem: 1014. Best Sightseeing Pair
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/best-sightseeing-pair/
 * Language: java
 * Date: 2026-04-11
 */

class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int res = 0;
        int max = 0;
        for (int i = 0; i < values.length; i++) {
            max--;
            if (values[i] + max > res)
                res = values[i] + max;
            if (values[i] > max)
                max = values[i];
        }
        return res;
    }
}
