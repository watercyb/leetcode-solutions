/*
 * Problem: 3967. Finish Time of Tasks II
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/finish-time-of-tasks-ii/
 * Language: java
 * Date: 2026-06-23
 */

class Solution {
    public long finishTime(int n, int[][] edges, int[] baseTime) {
        if (n == 1)
            return baseTime[0];
        int[] counts = new int[n];
        for (int[] edge : edges) {
            counts[edge[0]]++;
            counts[edge[1]]++;
        }
        int[][] links = new int[n][];
        for (int i = 0; i < n; i++) {
            links[i] = new int[counts[i]];
        }
        for (int[] edge : edges) {
            links[edge[0]][--counts[edge[0]]] = edge[1];
            links[edge[1]][--counts[edge[1]]] = edge[0];
        }
        prvMaxs = new long[n];
        prvMins = new long[n];
        dfs(links, baseTime, 0, -1, Long.MIN_VALUE, Long.MAX_VALUE);
        dfsRev(links, baseTime, 0, -1, Long.MIN_VALUE, Long.MAX_VALUE);
        return res;
    }

    long[] prvMaxs;
    long[] prvMins;
    long res = Long.MAX_VALUE;

    public long dfs(int[][] links, int[] baseTime, int i, int prv, long prvMax, long prvMin) {
        if (prv == -1) {
            if (links[i].length == 1) {
                dfs(links, baseTime, links[i][0], i, baseTime[i], baseTime[i]);
            } else {
                long max = Long.MIN_VALUE;
                long min = Long.MAX_VALUE;
                for (int next : links[i]) {
                    if (next == prv)
                        continue;
                    long re = dfs(links, baseTime, next, i, max, min);
                    max = Math.max(max, re);
                    min = Math.min(min, re);
                }
            }
            return -1;
        } else {
            prvMaxs[i] = prvMax;
            prvMins[i] = prvMin;
            if (links[i].length == 1) {
                return baseTime[i];
            } else {
                long max = Long.MIN_VALUE;
                long min = Long.MAX_VALUE;
                for (int next : links[i]) {
                    if (next == prv)
                        continue;
                    long re = dfs(links, baseTime, next, i, max, min);
                    max = Math.max(max, re);
                    min = Math.min(min, re);
                }
                return max * 2 - min + baseTime[i];
            }
        }
    }

    public long dfsRev(int[][] links, int[] baseTime, int i, int prv, long prvMax, long prvMin) {
        if (prv == -1) {
            if (links[i].length == 1) {
                long re = dfsRev(links, baseTime, links[i][0], i, baseTime[i], baseTime[i]);
                res = Math.min(res, re + baseTime[i]);
            } else {
                long max = Long.MIN_VALUE;
                long min = Long.MAX_VALUE;
                for (int j = links[i].length - 1; j >= 0; j--) {
                    int next = links[i][j];
                    if (next == prv)
                        continue;
                    long re = dfsRev(links, baseTime, next, i, max, min);
                    max = Math.max(max, re);
                    min = Math.min(min, re);
                }
                res = Math.min(res, max * 2 - min + baseTime[i]);
            }
            return -1;
        } else {
            long val = 0;
            if (links[prv].length == 1) {
                val = baseTime[prv];
            } else {
                prvMaxs[i] = Math.max(prvMaxs[i], prvMax);
                prvMins[i] = Math.min(prvMins[i], prvMin);
                val = prvMaxs[i] * 2 - prvMins[i] + baseTime[prv];
            }
            if (links[i].length == 1) {
                res = Math.min(res, val + baseTime[i]);
                return baseTime[i];
            } else {
                long max = Long.MIN_VALUE;
                long min = Long.MAX_VALUE;
                for (int j = links[i].length - 1; j >= 0; j--) {
                    int next = links[i][j];
                    if (next == prv)
                        continue;
                    long re = dfsRev(links, baseTime, next, i, Math.max(max, val), Math.min(min, val));
                    max = Math.max(max, re);
                    min = Math.min(min, re);
                }
                res = Math.min(res, Math.max(max, val) * 2 - Math.min(min, val) + baseTime[i]);
                return max * 2 - min + baseTime[i];
            }
        }
    }
}
