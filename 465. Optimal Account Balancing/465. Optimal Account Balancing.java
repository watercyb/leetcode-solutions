/*
 * Problem: 465. Optimal Account Balancing
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/optimal-account-balancing/?envType=weekly-question&envId=2026-10-11
 * Language: java
 * Date: 2026-10-13
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
        int[] seens = new int[1 << 12];
        Arrays.fill(seens, Integer.MAX_VALUE);
        dfs(amounts, seens, count, 0, 0, 0);
        return res;
    }

    int res = Integer.MAX_VALUE;

    public void dfs(int[] amounts, int[] seens, int count, int sum, int stp, int idx) {
        if (count == 0) {
            res = stp;
            return;
        }
        if (stp == res)
            return;
        if (sum != 0)
            stp++;
        if (seens[idx] <= stp)
            return;
        seens[idx] = stp;
        for (int i = 0; i < amounts.length; i++) {
            if (amounts[i] != 0) {
                int tmp = amounts[i];
                amounts[i] = 0;
                dfs(amounts, seens, count - 1, sum + tmp, stp, idx + (1 << i));
                amounts[i] = tmp;
            }
        }
    }
}
