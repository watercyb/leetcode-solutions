/*
 * Problem: 2867. Count Valid Paths in a Tree
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/count-valid-paths-in-a-tree/
 * Language: java
 * Date: 2026-05-01
 */

class Solution {
    public long countPaths(int n, int[][] edges) {
        boolean[] nonPrimes = getPrimes(n);
        int[] unionLinks = new int[n + 1];
        int[] counts = new int[n + 1];
        List<Integer>[] lists = new ArrayList[n + 1];
        for (int i = 0; i < lists.length; i++) {
            lists[i] = new ArrayList<>();
            unionLinks[i] = i;
            counts[i] = 1;
        }
        for (int[] edge : edges) {
            if (nonPrimes[edge[0]] && nonPrimes[edge[1]]) {
                int a = find(unionLinks, edge[0]);
                int b = find(unionLinks, edge[1]);
                if (a != b) {
                    unionLinks[a] = b;
                    counts[b] += counts[a];
                }
            }
        }
        long res = 0;
        int[] sums = new int[n + 1];
        for (int[] edge : edges) {
            if (!nonPrimes[edge[0]] && nonPrimes[edge[1]]) {
                long sum = counts[find(unionLinks, edge[1])];
                res += sum * (sums[edge[0]] + 1);
                sums[edge[0]] += sum;
            } else if (nonPrimes[edge[0]] && !nonPrimes[edge[1]]) {
                long sum = counts[find(unionLinks, edge[0])];
                res += sum * (sums[edge[1]] + 1);
                sums[edge[1]] += sum;
            }
        }
        return res;
    }

    public int find(int[] unionLinks, int i) {
        if (unionLinks[i] != i)
            unionLinks[i] = find(unionLinks, unionLinks[i]);
        return unionLinks[i];
    }

    public boolean[] getPrimes(int n) {
        boolean[] nonPrimes = new boolean[n + 1];
        nonPrimes[0] = true;
        nonPrimes[1] = true;
        for (int i = 2; i <= n; i++) {
            if (nonPrimes[i])
                continue;
            if ((long) i * i > n)
                break;
            for (int j = i * i; j <= n; j += i) {
                nonPrimes[j] = true;
            }
        }
        return nonPrimes;
    }
}
