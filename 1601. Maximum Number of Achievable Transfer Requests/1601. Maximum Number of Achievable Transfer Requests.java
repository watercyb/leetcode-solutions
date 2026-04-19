/*
 * Problem: 1601. Maximum Number of Achievable Transfer Requests
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/maximum-number-of-achievable-transfer-requests/
 * Language: java
 * Date: 2026-04-19
 */

class Solution {
    public int maximumRequests(int n, int[][] requests) {
        dfs(requests, new int[n], 0, 0);
        return res;
    }

    int res = 0;

    public void dfs(int[][] requests, int[] counts, int i, int n) {
        if (n + requests.length - i <= res)
            return;
        if (i == requests.length) {
            for (int count : counts) {
                if (count != 0)
                    return;
            }
            res = Math.max(n, res);
            return;
        }
        counts[requests[i][0]]--;
        counts[requests[i][1]]++;
        dfs(requests, counts, i + 1, n + 1);
        counts[requests[i][0]]++;
        counts[requests[i][1]]--;
        dfs(requests, counts, i + 1, n);
    }
}
