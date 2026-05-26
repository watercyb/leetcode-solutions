/*
 * Problem: 3939. Count Non Adjacent Subsets in a Rooted Tree
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/count-non-adjacent-subsets-in-a-rooted-tree/
 * Language: java
 * Date: 2026-05-26
 */

class Solution {
    public int countValidSubsets(int[] parent, int[] nums, int k) {
        int[] counts = new int[parent.length];
        for (int i = 1; i < parent.length; i++) {
            counts[parent[i]]++;
        }
        int[][] links = new int[parent.length][];
        for (int i = 0; i < parent.length; i++) {
            links[i] = new int[counts[i]];
        }
        for (int i = 1; i < parent.length; i++) {
            links[parent[i]][--counts[parent[i]]] = i;
        }
        long[][] res = dfs(links, nums, 0, k);
        return (int) ((res[0][0] + res[1][0] - 1 + mod) % mod);
    }

    int mod = 1_000_000_007;
    long sum = 0;

    public long[][] dfs(int[][] links, int[] nums, int i, int k) {
        long[] a = new long[k];
        long[] b = new long[k];
        a[nums[i] % k] = 1;
        b[0] = 1;
        for (int next : links[i]) {
            long[][] res = dfs(links, nums, next, k);
            long[] aNext = new long[k];
            long[] bNext = new long[k];
            for (int j = 0; j < k; j++) {
                if (a[j] != 0) {
                    for (int l = 0; l < k; l++) {
                        aNext[(j + l) % k] = (aNext[(j + l) % k] + a[j] * res[1][l]) % mod;
                    }
                }
                if (b[j] != 0) {
                    for (int l = 0; l < k; l++) {
                        bNext[(j + l) % k] = (bNext[(j + l) % k] + b[j] * (res[0][l] + res[1][l])) % mod;
                    }
                }
            }
            a = aNext;
            b = bNext;
        }
        return new long[][] { a, b };
    }
}
