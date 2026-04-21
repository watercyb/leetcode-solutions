/*
 * Problem: 1820. Maximum Number of Accepted Invitations
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-number-of-accepted-invitations/
 * Language: java
 * Date: 2026-04-21
 */

class Solution {
    public int maximumInvitations(int[][] grid) {
        int[][] links = new int[grid.length][];
        for (int i = 0; i < grid.length; i++) {
            int count = 0;
            for (int j = 0; j < grid[0].length; j++) {
                count += grid[i][j];
            }
            links[i] = new int[count];
            int idx = 0;
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    links[i][idx++] = j;
                }
            }
        }
        int[] invs = new int[grid[0].length];
        Arrays.fill(invs, -1);
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            if (dfs(links, invs, new boolean[grid.length], i))
                res++;
        }
        return res;
    }

    public boolean dfs(int[][] links, int[] invs, boolean[] seens, int i) {
        seens[i] = true;
        for (int idx : links[i]) {
            if (invs[idx] == -1 || (!seens[invs[idx]] && dfs(links, invs, seens, invs[idx]))) {
                invs[idx] = i;
                return true;
            }
        }
        return false;
    }
}
