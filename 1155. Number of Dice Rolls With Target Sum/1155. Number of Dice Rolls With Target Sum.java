/*
 * Problem: 1155. Number of Dice Rolls With Target Sum
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/
 * Language: java
 * Date: 2026-04-14
 */

class Solution {
    public int mod = 1000000007;

    public int numRollsToTarget(int n, int k, int target) {
        long[][] mems = new long[n + 1][target + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(mems[i], -1);
        }
        return (int) (dfs(mems, n, k, target));
    }

    public long dfs(long[][] mems, int n, int k, int target) {
        if (target < n)
            return 0;
        if (mems[n][target] != -1)
            return mems[n][target];
        if (n == 1) {
            if (k >= target) {
                return 1;
            } else {
                return 0;
            }
        }
        long res = 0;
        for (int i = 1; i < target; i++) {
            if (i < n / 2 || target - i < n - n / 2 || n / 2 * k < i || (n - n / 2) * k < target - i)
                continue;
            long a = dfs(mems, n / 2, k, i);
            long b = dfs(mems, n - n / 2, k, target - i);
            res += a * b % mod;
        }
        res = res % mod;
        mems[n][target] = res;
        return res;

    }

}
