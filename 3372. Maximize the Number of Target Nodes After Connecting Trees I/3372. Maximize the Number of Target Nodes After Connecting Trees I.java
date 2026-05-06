/*
 * Problem: 3372. Maximize the Number of Target Nodes After Connecting Trees I
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximize-the-number-of-target-nodes-after-connecting-trees-i/
 * Language: java
 * Date: 2026-05-06
 */

class Solution {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        int[] counts1 = getSums(edges1, k);
        int[] counts2 = getSums(edges2, k - 1);
        int max = 0;
        for (int count : counts2) {
            max = Math.max(count, max);
        }
        int[] res = new int[edges1.length + 1];
        for (int i = 0; i < res.length; i++) {
            res[i] = counts1[i] + max;
        }
        return res;
    }

    public int[] getSums(int[][] edges, int k) {
        int[][] links = getLinks(edges);
        int[] res = new int[links.length];
        for (int i = 0; i < links.length; i++) {
            res[i] = dfs(links, i, -1, 0, k);
        }
        return res;
    }

    public int dfs(int[][] links, int i, int prv, int lv, int k) {
        if (lv > k)
            return 0;
        int res = 1;
        for (int next : links[i]) {
            if (next == prv)
                continue;
            res += dfs(links, next, i, lv + 1, k);
        }
        return res;
    }

    public int[][] getLinks(int[][] edges) {
        List<Integer>[] lists = new List[edges.length + 1];
        for (int i = 0; i < lists.length; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            lists[edge[0]].add(edge[1]);
            lists[edge[1]].add(edge[0]);
        }
        int[][] res = new int[lists.length][];
        for (int i = 0; i < lists.length; i++) {
            res[i] = new int[lists[i].size()];
            for (int j = 0; j < res[i].length; j++) {
                res[i][j] = lists[i].get(j);
            }
        }
        return res;
    }
}
