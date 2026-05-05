/*
 * Problem: 3241. Time Taken to Mark All Nodes
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/time-taken-to-mark-all-nodes/
 * Language: java
 * Date: 2026-05-05
 */

class Solution {
    public int[] timeTaken(int[][] edges) {
        counts = new int[edges.length + 1];
        List<List<Integer>> links = new ArrayList<>();
        for (int i = 0; i <= edges.length; i++) {
            links.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            links.get(edge[0]).add(edge[1]);
            links.get(edge[1]).add(edge[0]);
        }
        
        for (int i = 0; i < arr.length; i++) {
            List<Integer> link = links.get(i);
            arr[i] = new int[link.size()];
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = link.get(j);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length == 1) {
                dfs(arr, new boolean[edges.length + 1], i, 0);
                dfs1(arr, new boolean[edges.length + 1], i, 0);
                return counts;
            }
        }
        return null;
    }

    int[] counts;

    public int dfs1(int[][] arr, boolean[] seens, int i, int sum) {
        seens[i] = true;
        int res = 0;
        int stp = 2 - (i & 1);
        for (int j = arr[i].length - 1; j >= 0; j--) {
            int next = arr[i][j];
            if (!seens[next])
                res = Math.max(dfs1(arr, seens, next, Math.max(sum, res) + stp), res);
        }
        counts[i] = Math.max(Math.max(sum, res), counts[i]);
        return res + stp;
    }

    public int dfs(int[][] arr, boolean[] seens, int i, int sum) {
        seens[i] = true;
        int res = 0;
        int stp = 2 - (i & 1);
        for (int next : arr[i]) {
            if (!seens[next])
                res = Math.max(dfs(arr, seens, next, Math.max(sum, res) + stp), res);
        }
        counts[i] = Math.max(sum, res);
        return res + stp;
    }
}
