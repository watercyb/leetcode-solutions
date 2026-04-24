/*
 * Problem: 2151. Maximum Good People Based on Statements
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/maximum-good-people-based-on-statements/
 * Language: java
 * Date: 2026-04-24
 */

class Solution {
    public int maximumGood(int[][] statements) {
        dfs(statements, new int[statements.length], 0, 0);
        return res;
    }

    int res = 0;

    public void dfs(int[][] statements, int[] isGood, int i, int count) {
        if (i - count >= statements.length - res)
            return;
        if (i == statements.length) {
            res = Math.max(count, res);
        } else {
            if (isGood[i] == 0) {
                int[] isGoodNext = isGood.clone();
                int j = 0;
                while (j < statements.length) {
                    if (statements[i][j] == 0) {
                        if (isGoodNext[j] == 1)
                            break;
                        isGoodNext[j] = -1;
                    } else if (statements[i][j] == 1) {
                        if (isGoodNext[j] == -1)
                            break;
                        isGoodNext[j] = 1;
                    }
                    j++;
                }
                if (j == statements.length) {
                    isGoodNext[i] = 1;
                    count++;
                    dfs(statements, isGoodNext, i + 1, count);
                    count--;
                }
                isGood[i] = -1;
                dfs(statements, isGood, i + 1, count);
                isGood[i] = 0;
            } else if (isGood[i] == -1) {
                dfs(statements, isGood, i + 1, count);
            } else if (isGood[i] == 1) {
                count++;
                int[] isGoodNext = isGood.clone();
                int j = 0;
                while (j < statements.length) {
                    if (statements[i][j] == 0) {
                        if (isGoodNext[j] == 1)
                            break;
                        isGoodNext[j] = -1;
                    } else if (statements[i][j] == 1) {
                        if (isGoodNext[j] == -1)
                            break;
                        isGoodNext[j] = 1;
                    }
                    j++;
                }
                if (j == statements.length)
                    dfs(statements, isGoodNext, i + 1, count);
            }
        }
    }
}
