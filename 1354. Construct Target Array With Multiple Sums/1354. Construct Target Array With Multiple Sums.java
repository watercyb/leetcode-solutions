/*
 * Problem: 1354. Construct Target Array With Multiple Sums
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/construct-target-array-with-multiple-sums/
 * Language: java
 * Date: 2026-04-16
 */

class Solution {
    public boolean isPossible(int[] target) {
        int idx = 0;
        int max = target[idx];
        int sum = max;
        for (int i = 1; i < target.length; i++) {
            sum += target[i];
            if (target[i] > max) {
                max = target[i];
                idx = i;
            }
        }
        if (max == 1)
            return true;
        int sumWithoutmax = sum - max;
        if (sumWithoutmax == 1)
            return true;
        if (sumWithoutmax <= 0 || sumWithoutmax >= max)
            return false;
        target[idx] = max % sumWithoutmax;
        if (target[idx] == 0)
            return false;
        return isPossible(target);
    }
}
