/*
 * Problem: 3812. Minimum Edge Toggles on a Tree
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimum-edge-toggles-on-a-tree/
 * Language: java
 * Date: 2026-05-11
 */

class Solution {
    public List<Integer> minimumFlips(int n, int[][] edges, String start, String target) {
        char[] chrsS = start.toCharArray();
        char[] chrsT = target.toCharArray();
        boolean[] isSames = new boolean[n];
        int sum = 0;
        for (int i = 0; i < chrsS.length; i++) {
            if (chrsS[i] != chrsT[i]) {
                sum++;
            } else {
                isSames[i] = true;
            }
        }
        if (sum % 2 == 1)
            return List.of(-1);
        int[] counts = new int[n];
        for (int[] edge : edges) {
            counts[edge[0]]++;
            counts[edge[1]]++;
        }
        int[][][] links = new int[n][][];
        for (int i = 0; i < n; i++) {
            links[i] = new int[counts[i]][];
        }
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            links[edge[0]][--counts[edge[0]]] = new int[] { edge[1], i };
            links[edge[1]][--counts[edge[1]]] = new int[] { edge[0], i };
        }
        dfs(links, isSames, 0, -1, -1);
        Collections.sort(res);
        return res;
    }

    List<Integer> res = new ArrayList<>();

    public void dfs(int[][][] links, boolean[] isSames, int i, int j, int prv) {
        for (int[] next : links[i]) {
            int idx = next[0];
            int idxEdge = next[1];
            if (idx == prv)
                continue;
            dfs(links, isSames, idx, idxEdge, i);
            if (!isSames[idx]) {
                isSames[i] = !isSames[i];
                res.add(idxEdge);
            }
        }
    }
}
