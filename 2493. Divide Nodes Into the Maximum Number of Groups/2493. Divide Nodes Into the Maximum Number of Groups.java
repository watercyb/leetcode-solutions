/*
 * Problem: 2493. Divide Nodes Into the Maximum Number of Groups
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/divide-nodes-into-the-maximum-number-of-groups/
 * Language: java
 * Date: 2026-04-27
 */

class Solution {
    public int magnificentSets(int n, int[][] edges) {
        List<List<Integer>> links = new ArrayList<>();
        int[] unionLinks = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            links.add(new ArrayList<>());
            unionLinks[i] = i;
        }
        int[] counts = new int[n + 1];
        for (int[] edge : edges) {
            links.get(edge[0]).add(edge[1]);
            links.get(edge[1]).add(edge[0]);
            int a = unionFind(unionLinks, edge[0]);
            int b = unionFind(unionLinks, edge[1]);
            if (a != b)
                unionLinks[a] = b;
            counts[edge[0]]++;
            counts[edge[1]]++;
        }
        int[][] arr = new int[n + 1][];
        for (int i = 1; i <= n; i++) {
            List<Integer> list = links.get(i);
            arr[i] = new int[list.size()];
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = list.get(j);
            }
        }
        int[] groupCounts = new int[n + 1];
        int[] Qu = new int[arr.length];
        for (int i = 1; i <= n; i++) {
            int a = unionFind(unionLinks, i);
            int count = bfs(arr, Qu, i);
            if (count == -1)
                return -1;
            groupCounts[a] = Math.max(count, groupCounts[a]);
        }
        int res = 0;
        for (int i = 1; i <= n; i++) {
            res += groupCounts[i];
        }
        return res;
    }

    public int unionFind(int[] links, int i) {
        if (links[i] != i)
            links[i] = unionFind(links, links[i]);
        return links[i];
    }

    public int bfs(int[][] arr, int[] Qu, int i) {
        int[] groups = new int[arr.length];
        int l = 0;
        int r = 0;
        groups[i] = 1;
        Qu[r++] = i;
        int res = 0;
        while (l < r) {
            int lim = r;
            while (l < lim) {
                int current = Qu[l++];
                for (int next : arr[current]) {
                    if (groups[next] == 0) {
                        groups[next] = groups[current] + 1;
                        Qu[r++] = next;
                    } else {
                        if (Math.abs(groups[current] - groups[next]) != 1)
                            return -1;
                    }
                }
            }
            res++;
        }
        return res;
    }
}
