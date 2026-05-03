/*
 * Problem: 3075. Maximize Happiness of Selected Children
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximize-happiness-of-selected-children/
 * Language: java
 * Date: 2026-05-03
 */

class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        int n = 0;
        long res = 0;
        int l = happiness.length - k;
        for (int i = happiness.length - 1; i >= l; i--) {
            int tmp = happiness[i] - n;
            if (tmp <= 0)
                return res;
            n++;
            res += tmp;
        }
        return res;
    }
}
