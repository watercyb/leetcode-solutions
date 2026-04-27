/*
 * Problem: 2421. Number of Good Paths
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/number-of-good-paths/
 * Language: java
 * Date: 2026-04-27
 */

class Solution {
    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        Arrays.sort(edges, (a, b) -> Math.max(vals[a[0]], vals[a[1]]) - Math.max(vals[b[0]], vals[b[1]]));
        int[] unionFind = new int[vals.length];
        for (int i = 0; i < vals.length; i++) {
            unionFind[i] = i;
        }
        int[] counts = new int[vals.length];
        Arrays.fill(counts, 1);
        int res = vals.length;
        for (int i = 0; i < edges.length; i++) {
            int a = find(unionFind, edges[i][0]);
            int b = find(unionFind, edges[i][1]);
            if (a != b) {
                if (vals[a] == vals[b]) {
                    res += counts[a] * counts[b];
                    counts[a] += counts[b];
                    unionFind[b] = a;
                } else if (vals[a] < vals[b]) {
                    unionFind[a] = b;
                } else {
                    unionFind[b] = a;
                }
            }
        }
        return res;
    }

    public int find(int[] unionFind, int i) {
        if (unionFind[i] != i)
            unionFind[i] = find(unionFind, unionFind[i]);
        return unionFind[i];
    }
}
