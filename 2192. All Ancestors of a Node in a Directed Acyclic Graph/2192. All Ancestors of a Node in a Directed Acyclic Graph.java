/*
 * Problem: 2192. All Ancestors of a Node in a Directed Acyclic Graph
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/all-ancestors-of-a-node-in-a-directed-acyclic-graph/
 * Language: java
 * Date: 2026-04-24
 */

class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> links = new ArrayList<>();
        BitSet[] ancs = new BitSet[n];
        for (int i = 0; i < n; i++) {
            links.add(new ArrayList<>());
        }
        boolean[] connected = new boolean[n];
        for (int[] edge : edges) {
            links.get(edge[1]).add(edge[0]);
            connected[edge[0]] = true;
        }
        for (int i = 0; i < n; i++) {
            if (!connected[i])
                dfs(links, ancs, i, n);
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> list = new ArrayList<>();
            int j = ancs[i].nextSetBit(0);
            while (j >= 0) {
                list.add(j);
                j = ancs[i].nextSetBit(j + 1);
            }
            res.add(list);
        }
        return res;
    }

    public BitSet dfs(List<List<Integer>> links, BitSet[] ancs, int i, int n) {
        if (ancs[i] != null)
            return ancs[i];
        ancs[i] = new BitSet(n);
        for (int next : links.get(i)) {
            ancs[i].set(next);
            ancs[i].or(dfs(links, ancs, next, n));
        }
        return ancs[i];
    }
}
