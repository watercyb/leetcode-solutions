/*
 * Problem: 1402. Reducing Dishes
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/reducing-dishes/
 * Language: java
 * Date: 2026-04-17
 */

class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int idx = 0;
        while (idx < satisfaction.length && satisfaction[idx] < 0) {
            idx++;
        }
        if (idx == satisfaction.length)
            return 0;
        int total = 0;
        int sum = 0;
        for (int i = idx; i < satisfaction.length; i++) {
            total += satisfaction[i] * (i - idx + 1);
            sum += satisfaction[i];
        }
        int res = total;
        for (int i = idx - 1; i >= 0; i--) {
            total += satisfaction[i] + sum;
            sum += satisfaction[i];
            res = Math.max(res, total);
        }
        return res;
    }
}
