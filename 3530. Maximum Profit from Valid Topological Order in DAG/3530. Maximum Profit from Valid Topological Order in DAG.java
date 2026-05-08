/*
 * Problem: 3530. Maximum Profit from Valid Topological Order in DAG
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/maximum-profit-from-valid-topological-order-in-dag/
 * Language: java
 * Date: 2026-05-08
 */

class Solution {
    public int maxProfit(int n, int[][] edges, int[] score) {
        List<Integer>[] lists = new ArrayList[n];
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            lists[i] = new ArrayList<>();
            arr[i][0] = score[i];
            arr[i][1] = i;
        }
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        int[] prvs = new int[n];
        for (int[] edge : edges) {
            lists[edge[0]].add(edge[1]);
            prvs[edge[1]] += 1 << edge[0];
        }
        return dfs(lists, arr, prvs, 0, 0);
    }

    HashMap<Integer, Integer> HM = new HashMap<>();
    int res = 0;

    public int dfs(List<Integer>[] lists, int[][] arr, int[] prvs, int h, int i) {
        if (i == lists.length)
            return 0;
        if (HM.containsKey(h))
            return HM.get(h);
        boolean hasMin = false;
        int res = 0;
        for (int j = 0; j < arr.length; j++) {
            if ((h & (1 << arr[j][1])) != 0)
                continue;
            if ((h | prvs[arr[j][1]]) == h) {
                res = Math.max(dfs(lists, arr, prvs, h + (1 << arr[j][1]), i + 1) + arr[j][0] * (i + 1), res);
                if (!hasMin)
                    break;
            } else {
                hasMin = true;
            }
        }
        HM.put(h, res);
        return res;
    }
}
