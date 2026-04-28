/*
 * Problem: 2581. Count Number of Possible Root Nodes
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/count-number-of-possible-root-nodes/
 * Language: java
 * Date: 2026-04-28
 */

class Solution {
    public int rootCount(int[][] edges, int[][] guesses, int k) {
        n = edges.length + 1;
        List<Integer>[] lists = new ArrayList[n];
        for (int i = 0; i < lists.length; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            lists[edge[0]].add(edge[1]);
            lists[edge[1]].add(edge[0]);
        }
        int[][] links = new int[lists.length][];
        for (int i = 0; i < links.length; i++) {
            links[i] = new int[lists[i].size()];
            for (int j = 0; j < links[i].length; j++) {
                links[i][j] = lists[i].get(j);
            }
        }
        HashSet<Long> HS = new HashSet<>(guesses.length, 0.99f);
        for (int[] guess : guesses) {
            HS.add((long) guess[0] * n + guess[1]);
        }
        counts = new int[n];
        dfs(links, HS, 0, -1, 0);
        dfsRev(links, HS, 0, -1, 0);
        int res = 0;
        for (int count : counts) {
            if (count >= k)
                res++;
        }
        return res;
    }

    int n;
    int[] counts;

    public int dfs(int[][] links, HashSet<Long> HS, int i, int prv, int sum) {
        int res = 0;
        for (int next : links[i]) {
            if (next == prv)
                continue;
            if (HS.contains(getH(next, i))) {
                res += dfs(links, HS, next, i, sum + res + 1);
            } else {
                res += dfs(links, HS, next, i, sum + res);
            }
            if (HS.contains(getH(i, next)))
                res++;
        }
        counts[i] = res + sum;
        return res;

    }

    public int dfsRev(int[][] links, HashSet<Long> HS, int i, int prv, int sum) {
        int res = 0;
        counts[i] += sum;
        for (int j = links[i].length - 1; j >= 0; j--) {
            int next = links[i][j];
            if (next == prv)
                continue;
            res += dfsRev(links, HS, next, i, sum + res);
            if (HS.contains(getH(i, next)))
                res++;
        }
        return res;
    }

    public long getH(long a, long b) {
        return a * n + b;
    }
}
