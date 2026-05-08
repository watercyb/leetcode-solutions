/*
 * Problem: 3575. Maximum Good Subtree Score
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/maximum-good-subtree-score/
 * Language: java
 * Date: 2026-05-08
 */

class Solution {
    public int goodSubtreeSum(int[] vals, int[] par) {
        List<Integer>[] lists = new ArrayList[vals.length];
        for (int i = 0; i < lists.length; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int i = 1; i < par.length; i++) {
            lists[par[i]].add(i);
        }
        int[][] links = new int[lists.length][];
        for (int i = 0; i < links.length; i++) {
            links[i] = new int[lists[i].size()];
            for (int j = 0; j < links[i].length; j++) {
                links[i][j] = lists[i].get(j);
            }
        }
        dfs(links, vals, 0);
        return (int) (res % 1_000_000_007);
    }

    long res = 0;

    public int[] dfs(int[][] links, int[] vals, int i) {
        int h = getH(vals[i]);
        int[] DP = new int[1024];
        if (h != -1)
            DP[h] = vals[i];
        for (int next : links[i]) {
            int[] DPNext = dfs(links, vals, next);
            combine(DP, DPNext);
        }
        int max = 0;
        for (int j = 0; j < DP.length; j++) {
            max = Math.max(max, DP[j]);
        }
        res = res + max;
        return DP;
    }

    public void combine(int[] DP, int[] DPNext) {
        for (int i = 0; i < 1024; i++) {
            if (DPNext[i] == 0)
                continue;
            int mask = 1023 ^ i;
            for (int j = mask; j != 0; j = (j - 1) & mask) {
                DP[i | j] = Math.max(DPNext[i] + DP[j], DP[i | j]);
            }
            DP[i] = Math.max(DPNext[i], DP[i]);
        }
    }

    public int getH(int num) {
        int res = 0;
        while (num > 0) {
            int mask = 1 << (num % 10);
            if ((res & mask) != 0)
                return -1;
            res += mask;
            num /= 10;
        }
        return res;
    }
}
