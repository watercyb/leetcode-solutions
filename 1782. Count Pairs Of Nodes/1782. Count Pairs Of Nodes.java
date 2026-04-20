/*
 * Problem: 1782. Count Pairs Of Nodes
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/count-pairs-of-nodes/
 * Language: java
 * Date: 2026-04-20
 */

class Solution {
    public int[] countPairs(int n, int[][] edges, int[] queries) {
        int[][] counts = new int[n][];
        for (int i = 0; i < n; i++) {
            counts[i] = new int[] { 0, i };
        }
        for (int[] edge : edges) {
            if (edge[0] > edge[1]) {
                int edgeTemp = edge[0];
                edge[0] = edge[1];
                edge[1] = edgeTemp;
            }
            edge[0]--;
            edge[1]--;
            counts[edge[0]][0]++;
            counts[edge[1]][0]++;
        }
        Arrays.sort(counts, (a, b) -> a[0] - b[0]);
        int[] idx = new int[n];
        for (int i = 0; i < n; i++) {
            idx[counts[i][1]] = i;
        }
        Arrays.sort(edges, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        List<int[]>[] links = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            links[i] = new ArrayList<>();
        }
        int[] prv = edges[0];
        int count = 1;
        for (int i = 1; i < edges.length; i++) {
            if (edges[i][0] == prv[0]) {
                if (edges[i][1] == prv[1]) {
                    count++;
                } else {
                    int a = idx[prv[0]];
                    int b = idx[prv[1]];
                    if (a > b) {
                        links[b].add(new int[] { counts[a][0], count });
                    } else {
                        links[a].add(new int[] { counts[b][0], count });
                    }
                    prv = edges[i];
                    count = 1;
                }
            } else {
                int a = idx[prv[0]];
                int b = idx[prv[1]];
                if (a > b) {
                    links[b].add(new int[] { counts[a][0], count });
                } else {
                    links[a].add(new int[] { counts[b][0], count });
                }
                prv = edges[i];
                count = 1;
            }
        }
        if (idx[prv[0]] > idx[prv[1]]) {
            links[idx[prv[1]]].add(new int[] { counts[idx[prv[0]] ][0], count });
        } else {
            links[idx[prv[0]] ].add(new int[] { counts[idx[prv[1]]][0], count });
        }
        for (int i = 0; i < n; i++) {
            Collections.sort(links[i], (a, b) -> b[0] - a[0]);
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            res[i] = getCount(links, counts, idx, queries[i]);
        }
        return res;
    }

    public int getCount(List<int[]>[] links, int[][] counts, int[] idx, int n) {
        int j = counts.length - 1;
        while (j >= 0 && counts[j][0] > n) {
            j--;
        }
        int count = counts.length - 1 - j;
        int res = (counts.length - 1 + counts.length - count) * count / 2;
        int k = j;
        for (int i = 0; i < k; i++) {
            while (j > i && counts[j][0] + counts[i][0] > n) {
                j--;
            }
            if (j < i)
                j++;
            res += k - j;
            List<int[]> list = links[i];
            for (int l = 0; l < list.size(); l++) {
                int[] arr = list.get(l);
                if (counts[i][0] + arr[0] <= n)
                    break;
                if (counts[i][0] + arr[0] - arr[1] <= n)
                    res--;
            }
        }
        return res;
    }
}
