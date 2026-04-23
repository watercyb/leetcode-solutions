/*
 * Problem: 2076. Process Restricted Friend Requests
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/process-restricted-friend-requests/
 * Language: java
 * Date: 2026-04-23
 */

class Solution {
    public boolean[] friendRequests(int n, int[][] restrictions, int[][] requests) {
        int[] links = new int[n];
        boolean[][] rests = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            links[i] = i;
        }
        for (int[] restriction : restrictions) {
            rests[restriction[0]][restriction[1]] = true;
            rests[restriction[1]][restriction[0]] = true;
        }
        boolean[] res = new boolean[requests.length];
        for (int i = 0; i < requests.length; i++) {
            int a = unionFind(links, requests[i][0]);
            int b = unionFind(links, requests[i][1]);
            if (!rests[a][b]) {
                res[i] = true;
                links[a] = b;
                for (int j = 0; j < n; j++) {
                    if (rests[a][j]) {
                        rests[b][j] = true;
                        rests[j][b] = true;
                    }
                }
            }
        }
        return res;
    }

    public int unionFind(int[] links, int i) {
        if (links[i] != i)
            links[i] = unionFind(links, links[i]);
        return links[i];
    }
}
