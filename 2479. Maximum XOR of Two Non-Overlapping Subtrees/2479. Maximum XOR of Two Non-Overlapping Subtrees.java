/*
 * Problem: 2479. Maximum XOR of Two Non-Overlapping Subtrees
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/maximum-xor-of-two-non-overlapping-subtrees/
 * Language: java
 * Date: 2026-04-27
 */

class Solution {
    public long maxXor(int n, int[][] edges, int[] values) {
        List<Integer>[] lists = new ArrayList[n];
        for (int i = 0; i < lists.length; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            lists[edge[0]].add(edge[1]);
            lists[edge[1]].add(edge[0]);
        }
        long[] sums = new long[n];
        long max = dfs(lists, values, sums, 0, -1);
        int len = 64 - Long.numberOfLeadingZeros(max);
        Node root = new Node();
        return dfs(lists, sums, root, 0, -1, len);
    }

    public long dfs(List<Integer>[] lists, int[] values, long[] sums, int i, int prv) {
        long res = values[i];
        for (int next : lists[i]) {
            if (next != prv)
                res += dfs(lists, values, sums, next, i);
        }
        return sums[i] = res;
    }

    public long dfs(List<Integer>[] lists, long[] sums, Node root, int i, int prv, int len) {
        long res = 0;
        long sum = sums[i];
        Node node = root;
        if (root.next[0] != null || root.next[1] != null) {
            for (int j = len - 1; j >= 0; j--) {
                long base = 1l << j;
                int idx = (base & sum) == 0 ? 1 : 0;
                if (node.next[idx] != null) {
                    res += 1l << j;
                    node = node.next[idx];
                } else {
                    node = node.next[1 - idx];
                }
            }
        }
        for (int next : lists[i]) {
            if (next != prv)
                res = Math.max(dfs(lists, sums, root, next, i, len), res);
        }
        node = root;
        for (int j = len - 1; j >= 0; j--) {
            long base = 1l << j;
            int idx = (base & sum) == 0 ? 0 : 1;
            if (node.next[idx] == null)
                node.next[idx] = new Node();
            node = node.next[idx];
        }
        return sums[i] = res;
    }
}

class Node {
    Node[] next = new Node[2];
}
