/*
 * Problem: 851. Loud and Rich
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/loud-and-rich/
 * Language: java
 * Date: 2026-04-09
 */

class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        List<Integer>[] links = new ArrayList[quiet.length];
        for (int i = 0; i < links.length; i++) {
            links[i] = new ArrayList<>();
        }
        for (int[] pair : richer) {
            links[pair[0]].add(pair[1]);
        }
        int[] res = new int[links.length];
        Arrays.fill(res, -1);
        for (int i = 0; i < links.length; i++) {
            if (res[i] == -1)
                dfs(links, i, res, i, quiet);
        }
        return res;
    }

    public void dfs(List<Integer>[] links, int i, int[] res, int min, int[] quiet) {
        if (res[i] == -1) {
            if (quiet[i] < quiet[min])
                min = i;
            res[i] = min;
        } else if (quiet[res[i]] > quiet[min]) {
            res[i] = min;
        } else {
            return;
        }
        for (int next : links[i]) {
            dfs(links, next, res, min, quiet);
        }
    }
}
