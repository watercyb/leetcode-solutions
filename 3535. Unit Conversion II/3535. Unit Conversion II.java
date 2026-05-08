/*
 * Problem: 3535. Unit Conversion II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/unit-conversion-ii/
 * Language: java
 * Date: 2026-05-08
 */

class Solution {
    public int[] queryConversions(int[][] conversions, int[][] queries) {
        List<int[]>[] lists = new ArrayList[conversions.length + 1];
        for (int i = 0; i < lists.length; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int[] edge : conversions) {
            lists[edge[0]].add(new int[] { edge[1], edge[2] });
            lists[edge[1]].add(new int[] { edge[0], -edge[2] });
        }
        a = new long[lists.length];
        b = new long[lists.length];
        dfs(lists, 0, -1, 1, 1);
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            long n1 = b[queries[i][0]] * a[queries[i][1]];
            long n2 = a[queries[i][0]] * b[queries[i][1]];
            res[i] = (int) (n1 * rev(n2) % mod);
        }
        return res;
    }

    int mod = 1_000_000_007;
    long[] a;
    long[] b;

    public void dfs(List<int[]>[] lists, int i, int prv, long p1, long p2) {
        a[i] = p1;
        b[i] = p2;
        for (int[] next : lists[i]) {
            if (next[0] == prv)
                continue;
            if (next[1] > 0) {
                dfs(lists, next[0], i, p1 * next[1] % mod, p2);
            } else {
                dfs(lists, next[0], i, p1, p2 * -next[1] % mod);
            }
        }
    }

    public long rev(long a) {
        if (a == 1)
            return 1;
        return mod - mod / a * rev(mod % a) % mod;
    }

    public long rev_prime(long a) {
        return pow(a, mod - 2);
    }

    public long pow(long a, int b) {
        long res = 1;
        while (b > 0) {
            if ((b & 1) == 1)
                res = res * a % mod;
            a = a * a % mod;
            b >>= 1;
        }
        return res;
    }
}
