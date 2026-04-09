/*
 * Problem: 886. Possible Bipartition
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/possible-bipartition/
 * Language: java
 * Date: 2026-04-09
 */

class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        if (dislikes.length == 0)
            return true;
        List<Integer>[] lists = new ArrayList[n];
        for (int i = 0; i < lists.length; i++) {
            lists[i] = new ArrayList<>();
        }
        int[] seens = new int[n];
        for (int[] edge : dislikes) {
            lists[edge[0] - 1].add(edge[1] - 1);
            lists[edge[1] - 1].add(edge[0] - 1);
        }
        for (int i = 0; i < n; i++) {
            if (seens[i] == 0 && !dfs(lists, seens, i, 1))
                return false;
        }
        return true;
    }

    public boolean dfs(List<Integer>[] lists, int[] seens, int idx, int label) {
        if (seens[idx] == label)
            return true;
        if (seens[idx] == 0) {
            seens[idx] = label;
            label ^= 3;
            for (int next : lists[idx]) {
                if (!dfs(lists, seens, next, label))
                    return false;
            }
            return true;
        } else {
            return false;
        }
    }
}
