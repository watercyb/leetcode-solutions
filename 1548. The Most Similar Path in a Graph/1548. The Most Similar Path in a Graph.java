/*
 * Problem: 1548. The Most Similar Path in a Graph
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/the-most-similar-path-in-a-graph/
 * Language: java
 * Date: 2026-04-18
 */

class Solution {
    public List<Integer> mostSimilar(int n, int[][] roads, String[] names, String[] targetPath) {
        List<Integer>[] lists = new ArrayList[n];
        for (int i = 0; i < lists.length; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int[] road : roads) {
            lists[road[0]].add(road[1]);
            lists[road[1]].add(road[0]);
        }
        int[][] links = new int[lists.length][];
        for (int i = 0; i < links.length; i++) {
            links[i] = new int[lists[i].size()];
            for (int j = 0; j < links[i].length; j++) {
                links[i][j] = lists[i].get(j);
            }
        }
        int[][] DP = new int[targetPath.length][n];
        int[][] DP1 = new int[targetPath.length][n];
        for (int i = 0; i < n; i++) {
            DP[0][i] = names[i].equals(targetPath[0]) ? 1 : 0;
        }
        for (int i = 1; i < targetPath.length; i++) {
            for (int j = 0; j < n; j++) {
                DP1[i][j] = links[j][0];
                int stp = names[j].equals(targetPath[i]) ? 1 : 0;
                for (int prv : links[j]) {
                    if (DP[i][j] < DP[i - 1][prv] + stp) {
                        DP[i][j] = DP[i - 1][prv] + stp;
                        DP1[i][j] = prv;
                    }
                }
            }
        }
        int max = 0;
        int idx = 0;
        for (int i = 0; i < n; i++) {
            if (DP[DP.length - 1][i] > max) {
                max = DP[DP.length - 1][i];
                idx = i;
            }
        }
        List<Integer> res = new ArrayList<>();
        res.add(idx);
        for (int i = targetPath.length - 1; i >= 1; i--) {
            idx = DP1[i][idx];
            res.addFirst(idx);
        }
        return res;
    }
}
