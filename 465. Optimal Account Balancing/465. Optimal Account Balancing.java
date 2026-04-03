/*
 * Problem: 465. Optimal Account Balancing
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/optimal-account-balancing/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public int minTransfers(int[][] transactions) {
        int[] amounts = new int[12];
        int count = 0;
        for (int[] transaction : transactions) {
            if (amounts[transaction[0]] == 0)
                count++;
            if (amounts[transaction[1]] == 0)
                count++;
            amounts[transaction[0]] -= transaction[2];
            amounts[transaction[1]] += transaction[2];
            if (amounts[transaction[0]] == 0)
                count--;
            if (amounts[transaction[1]] == 0)
                count--;
        }
        int base = 1;
        for (int i = 0; i <= 12; i++) {
            masks[i] = base;
            base <<= 1;
        }
        // System.out.println(Arrays.toString(masks));
        dfs(amounts, new boolean[count * (1 << 12)], count, 0, 0, 0);
        return res;
    }

    int res = Integer.MAX_VALUE;
    int[] masks = new int[13];

    public void dfs(int[] amounts, boolean[] seens, int count, int sum, int stp, int idx) {
        if (count == 0) {
            res = Math.min(stp, res);
            return;
        }
        if (stp == res)
            return;
        if (sum != 0) {
            stp++;
            seens[idx] = true;
        } else {
            idx += masks[12];

        }
        for (int i = 0; i < amounts.length; i++) {
            int idxTmp = idx + masks[i];
            if (amounts[i] != 0 && !seens[idxTmp]) {
                int tmp = amounts[i];
                amounts[i] = 0;
                dfs(amounts, seens, count - 1, sum + tmp, stp, idxTmp);
                amounts[i] = tmp;
            }
        }
    }
}
