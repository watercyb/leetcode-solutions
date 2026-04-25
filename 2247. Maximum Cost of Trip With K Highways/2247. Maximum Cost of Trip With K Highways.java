/*
 * Problem: 2247. Maximum Cost of Trip With K Highways
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/maximum-cost-of-trip-with-k-highways/
 * Language: java
 * Date: 2026-04-25
 */


class Solution {
    public int maximumCost(int n, int[][] highways, int k) {
        if (k>=n) return -1;
        List<int[]>[] lists = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int[] edge : highways) {
            lists[edge[0]].add(new int[] { edge[1], edge[2] });
            lists[edge[1]].add(new int[] { edge[0], edge[2] });
        }
        int[][][] links = new int[n][][];
        for (int i = 0; i < links.length; i++) {
            links[i] = new int[lists[i].size()][];
            for (int j = 0; j < links[i].length; j++) {
                links[i][j] = lists[i].get(j);
            }
        }
        int[][] DP = new int[1 << n][n];
        for (int[] row : DP) {
            Arrays.fill(row, -1);
        }
        for (int i = 0; i < n; i++) {
            DP[1 << i][i] = 0;
        }
        int res = -1;
        for (int i = 0; i < DP.length; i++) {
            if (Integer.bitCount(i)==k+1) {
                for (int j=0;j<n;j++){
                    res=Math.max(res,DP[i][j]);}
                  
            } else {
                for (int j = 0; j < n; j++) {
                    if (DP[i][j] ==-1)
                        continue;
                    for (int[] next : links[j]) {
                        if ((i & (1 << next[0])) != 0)
                            continue;
                        DP[i + (1 << next[0])][next[0]] = Math.max(DP[i + (1 << next[0])][next[0]], DP[i][j] + next[1]);
                    }
                }
            }
        }
        return res;
    }
}
