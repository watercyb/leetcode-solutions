/*
 * Problem: 3786. Total Sum of Interaction Cost in Tree Groups
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/total-sum-of-interaction-cost-in-tree-groups/
 * Language: java
 * Date: 2026-05-10
 */

class Solution {
    public long interactionCosts(int n, int[][] edges, int[] group) {
        List<Integer>[] lists = new ArrayList[n];
        for (int i = 0; i < lists.length; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            lists[edge[0]].add(edge[1]);
            lists[edge[1]].add(edge[0]);
        }
        int[][] links = new int[lists.length][];
        for (int i = 0; i < links.length; i++) {
            links[i] = new int[lists[i].size()];
            for (int j = 0; j < links[i].length; j++) {
                links[i][j] = lists[i].get(j);
            }
        }
        boolean[] seens = new boolean[21];
        int max = 0;
        for (int g : group) {
            seens[g] = true;
            max = Math.max(max, g);
        }
        int[] indexes = new int[21];
        for (int i = 1; i < seens.length; i++) {
            indexes[i] = indexes[i - 1];
            if (seens[i])
                indexes[i]++;
        }
        for (int i = 0; i < group.length; i++) {
            group[i] = indexes[group[i]] - 1;
        }
        dfs(links, group, 0, -1, max);
        return res;
    }

    long res = 0;

    public Node dfs(int[][] links, int[] group, int i, int prv, int n) {
        Node currentNode = new Node(n);
        currentNode.counts[group[i]]++;
        for (int next : links[i]) {
            if (next == prv)
                continue;
            Node node = dfs(links, group, next, i, n);
            for (int j = 0; j < n; j++) {
                res += node.sums[j] * currentNode.counts[j] + currentNode.sums[j] * node.counts[j];
                currentNode.counts[j] += node.counts[j];
                currentNode.sums[j] += node.sums[j];
            }
        }
        for (int j = 0; j < n; j++) {
            currentNode.sums[j] += currentNode.counts[j];
        }
        return currentNode;
    }
}

class Node {
    int[] counts;
    long[] sums;

    public Node(int n) {
        counts = new int[n];
        sums = new long[n];
    }
}
