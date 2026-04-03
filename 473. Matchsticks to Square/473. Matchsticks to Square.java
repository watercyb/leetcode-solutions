/*
 * Problem: 473. Matchsticks to Square
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/matchsticks-to-square/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public boolean makesquare(int[] matchsticks) {
        int sum = 0;
        int max = 0;
        for (int stick : matchsticks) {
            sum += stick;
            max = Math.max(max, stick);
        }
        if (sum % 4 != 0)
            return false;
        int lim = sum / 4;
        if (max > lim)
            return false;
        Arrays.sort(matchsticks);
        return dfs(matchsticks, new boolean[matchsticks.length], matchsticks.length - 1, 0, 0, lim);
    }

    public boolean dfs(int[] matchsticks, boolean[] seens, int idx, int n, int count, int lim) {
        if (n == 4)
            return true;
        if (count == lim)
            return dfs(matchsticks, seens, matchsticks.length - 1, n + 1, 0, lim);
        for (int i = idx; i >= 0; i--) {
            if (!seens[i] && count + matchsticks[i] <= lim) {
                seens[i] = true;
                if (dfs(matchsticks, seens, idx - 1, n, count + matchsticks[i], lim))
                    return true;
                seens[i] = false;
                if (count == 0)
                    return false;
                while (i > 0 && matchsticks[i - 1] == matchsticks[i]) {
                    i--;
                }
            }
        }
        return false;
    }
}

