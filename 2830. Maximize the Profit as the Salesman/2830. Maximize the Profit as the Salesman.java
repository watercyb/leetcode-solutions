/*
 * Problem: 2830. Maximize the Profit as the Salesman
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximize-the-profit-as-the-salesman/
 * Language: java
 * Date: 2026-05-01
 */

class Solution {
    public int maximizeTheProfit(int n, List<List<Integer>> offers) {
        List<int[]>[] lists = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            lists[i] = new ArrayList<>();
        }
        for (List<Integer> list : offers) {
            lists[list.get(1)].add(new int[] { list.get(0), list.get(2) });
        }
        int[] DP = new int[n + 1];
        for (int i = 0; i < n; i++) {
            DP[i + 1] = DP[i];
            if (lists[i].isEmpty())
                continue;
            for (int[] arr : lists[i]) {
                DP[i + 1] = Math.max(DP[arr[0]] + arr[1], DP[i + 1]);
            }
        }
        return DP[n];
    }
}
