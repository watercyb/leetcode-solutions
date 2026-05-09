/*
 * Problem: 3615. Longest Palindromic Path in Graph
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/longest-palindromic-path-in-graph/
 * Language: java
 * Date: 2026-05-09
 */

class Solution {
    public int maxLen(int n, int[][] edges, String label) {
        char[] chrs = label.toCharArray();
        List<Integer>[] lists = new ArrayList[n];
        int[] counts = new int[26];
        for (int i = 0; i < lists.length; i++) {
            lists[i] = new ArrayList<>();
            counts[chrs[i] - 'a']++;
        }
        connected = new boolean[n][n];
        for (int[] edge : edges) {
            lists[edge[0]].add(edge[1]);
            lists[edge[1]].add(edge[0]);
            connected[edge[0]][edge[1]] = connected[edge[1]][edge[0]] = true;
        }
        boolean hasOdd = false;
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] % 2 == 1) {
                hasOdd = true;
                lim += counts[i] - 1;
            } else {
                lim += counts[i];
            }
        }
        if (hasOdd)
            lim++;
        if (lim <= 1)
            return lim;
        seens = new boolean[1 << n][n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (chrs[i] == chrs[j] && dfs(lists, chrs, i, j, 0, 0))
                    return res;
            }
        }
        return res;
    }

    boolean[][] connected;
    boolean[][][] seens;
    int res = 1;
    int lim = 0;

    public boolean dfs(List<Integer>[] lists, char[] chrs, int i, int j, int h, int n) {
        if (i == j) {
            if (n + 1 > res) {
                res = n + 1;
                if (res == lim)
                    return true;
            }
            return false;
        }
        if (connected[i][j]) {
            if (n + 2 > res) {
                res = n + 2;
                if (res == lim)
                    return true;
            }
        }
        n += 2;
        h += (1 << i) + (1 << j);
        if (seens[h][i][j])
            return false;
        seens[h][i][j] = true;
        seens[h][j][i] = true;
        for (int nextL : lists[i]) {
            if ((h & (1 << nextL)) != 0)
                continue;
            for (int nextR : lists[j]) {
                if (chrs[nextL] != chrs[nextR] || (h & (1 << nextR)) != 0)
                    continue;
                if (dfs(lists, chrs, nextL, nextR, h, n))
                    return true;
            }
        }
        return false;
    }
}
