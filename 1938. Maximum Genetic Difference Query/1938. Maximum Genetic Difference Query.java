/*
 * Problem: 1938. Maximum Genetic Difference Query
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/maximum-genetic-difference-query/
 * Language: java
 * Date: 2026-04-22
 */

class Solution {
    public int[] maxGeneticDifference(int[] parents, int[][] queries) {
        int max = 0;
        for (int[] query : queries) {
            max = Math.max(query[1], max);
        }
        int len = (int) (Math.log(Math.max(parents.length, max)) / Math.log(2)) + 1;
        List<Integer>[] lists = new ArrayList[parents.length];
        for (int i = 0; i < parents.length; i++) {
            lists[i] = new ArrayList<>();
        }
        int r = 0;
        for (int i = 0; i < parents.length; i++) {
            if (parents[i] == -1) {
                r = i;
            } else {
                lists[parents[i]].add(i);
            }
        }
        int[][] links = new int[lists.length][];
        for (int i = 0; i < links.length; i++) {
            links[i] = new int[lists[i].size()];
            for (int j = 0; j < links[i].length; j++) {
                links[i][j] = lists[i].get(j);
            }
        }
        Node root = new Node();
        List<int[]>[] listQue = new ArrayList[parents.length];
        for (int i = 0; i < queries.length; i++) {
            if (listQue[queries[i][0]] == null)
                listQue[queries[i][0]] = new ArrayList<>();
            listQue[queries[i][0]].add(new int[] { queries[i][1], i });
        }

        isEmpty = new boolean[parents.length];
        dfs(links, listQue, r);

        res = new int[queries.length];
        dfs(links, listQue, r, root, len);

        return res;
    }

    boolean[] isEmpty;

    public boolean dfs(int[][] links, List<int[]>[] listQue, int i) {
        boolean res = listQue[i] == null;
        for (int next : links[i]) {
            res &= dfs(links, listQue, next);
        }
        return isEmpty[i] = res;
    }

    int[] res;

    public void dfs(int[][] links, List<int[]>[] listQue, int i, Node root, int len) {
        if (isEmpty[i])
            return;
        update(root, i, 1, len);
        getMax(listQue[i], root, i, len);
        for (int j = 0; j < links[i].length; j++) {
            dfs(links, listQue, links[i][j], root, len);
        }
        update(root, i, -1, len);
    }

    public void getMax(List<int[]> list, Node root, int i, int len) {
        if (list == null)
            return;
        for (int[] pair : list) {
            int num = pair[0];
            int xor = 0;
            Node node = root;
            for (int j = len - 1; j >= 0; j--) {
                int base = 1 << j;
                int nextIdx = (num & base) == 0 ? 1 : 0;
                if (node.next[nextIdx] != null && node.next[nextIdx].count > 0) {
                    xor += base;
                    node = node.next[nextIdx];
                } else {
                    node = node.next[1 - nextIdx];
                }
            }
            res[pair[1]] = xor;
        }
    }

    public void update(Node root, int num, int n, int len) {
        for (int j = len - 1; j >= 0; j--) {
            root.count += n;
            int base = 1 << j;
            int idx = (num & base) == 0 ? 0 : 1;
            if (root.next[idx] == null)
                root.next[idx] = new Node();
            root = root.next[idx];
        }
        root.count += n;
    }
}

class Node {
    Node[] next = new Node[2];
    int count = 0;
}
