/*
 * Problem: 1896. Minimum Cost to Change the Final Value of Expression
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimum-cost-to-change-the-final-value-of-expression/
 * Language: java
 * Date: 2026-04-21
 */

class Solution {
    public int minOperationsToFlip(String expression) {
        int[] res = dfs(expression.toCharArray());
        return Math.max(res[0], res[1]);
    }

    int[][][] ops = { { { 0, 1 }, { 0, 0 } }, { { 1, 1 }, { 0, 1 } } };
    int idx = 0;

    public int[] dfs(char[] chrs) {
        int[] res = null;
        int operator = 0;
        while (idx < chrs.length && chrs[idx] != ')') {
            if (chrs[idx] == '(') {
                idx++;
                res = insert(res, operator, dfs(chrs));
            } else if (chrs[idx] == '|') {
                operator = 0;
                idx++;
            } else if (chrs[idx] == '&') {
                operator = 1;
                idx++;
            } else {
                int[] resTemp = new int[2];
                resTemp[1 - chrs[idx] + '0']++;
                res = insert(res, operator, resTemp);
                idx++;
            }
        }
        idx++;
        return res;
    }

    public int[] insert(int[] res, int operator, int[] arr) {
        if (res == null) {
            return arr;
        } else {
            int[] resNext = { Integer.MAX_VALUE, Integer.MAX_VALUE };
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    resNext[ops[j][operator][k]] = Math.min(res[j] + arr[k],
                            resNext[ops[j][operator][k]]);
                    resNext[ops[j][1 - operator][k]] = Math.min(res[j] + arr[k] + 1,
                            resNext[ops[j][1 - operator][k]]);
                }
            }
            return resNext;
        }
    }
}
