/*
 * Problem: 1697. Checking Existence of Edge Length Limited Paths
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/checking-existence-of-edge-length-limited-paths/
 * Language: java
 * Date: 2026-04-19
 */

class Solution {
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        long[] edgeListSort = new long[edgeList.length];
        long[] queriesSort = new long[queries.length];
        for (int i = 0; i < edgeList.length; i++) {
            edgeListSort[i] = edgeList[i][2] * 100001l + i;
        }
        for (int i = 0; i < queries.length; i++) {
            queriesSort[i] = queries[i][2] * 100001l + i;
        }
        Arrays.sort(edgeListSort);
        Arrays.sort(queriesSort);
        int[] links = new int[n];
        for (int i = 0; i < n; i++) {
            links[i] = i;
        }
        boolean[] res = new boolean[queries.length];
        int j = 0;
        for (int i = 0; i < queriesSort.length; i++) {
            int idxQ = (int) (queriesSort[i] % 100001);
            while (j < edgeListSort.length) {
                int idxE = (int) (edgeListSort[j] % 100001);
                if (edgeList[idxE][2] >= queries[idxQ][2])
                    break;
                int a = find(links, edgeList[idxE][0]);
                int b = find(links, edgeList[idxE][1]);
                if (a != b)
                    links[a] = b;
                j++;
            }
            res[idxQ] = find(links, queries[idxQ][0]) == find(links, queries[idxQ][1]);
        }
        return res;
    }

    public int find(int[] links, int i) {
        if (links[i] != i)
            links[i] = find(links, links[i]);
        return links[i];
    }
}
