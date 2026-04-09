/*
 * Problem: 818. Race Car
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/race-car/
 * Language: java
 * Date: 2026-04-09
 */

class Solution {
    public int racecar(int target) {
        int[] mems = new int[target + 1];
        return dfs(mems, target);
    }

    public int dfs(int[] mems, int target) {
        if (mems[target] != 0)
            return mems[target];
        int n = 2;
        int stp = 1;
        while (n - 1 < target) {
            n *= 2;
            stp++;
        }
        if (n - 1 == target)
            return stp;
        mems[target] = dfs(mems, n - 1 - target) + stp + 1;
        n /= 2;
        for (int i = 1; i < n; i *= 2) {
            mems[target] = Math.min(dfs(mems, target - (n - 1) + i - 1) + stp - 1 + 2,
                    mems[target]);
            stp++;
        }
        return mems[target];
    }
}
