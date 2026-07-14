/*
 * Problem: Unknown Problem
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/distinct-gate-paths-to-lca/
 * Language: java
 * Date: 2026-07-14
 */

class Solution {
    public int distinctPaths(int n, int[] parent, int[][] gates, int[][] queries) {
        boolean[] hasChilds = new boolean[n];
        for (int p : parent) {
            if (p == -1)
                continue;
            hasChilds[p] = true;
        }
        depths = new int[n];
        Arrays.fill(depths, -1);
        int max = getDepth(parent);
        for (int depth : depths) {
            max = Math.max(max, depth);
        }
        len = 32 - Integer.numberOfLeadingZeros(max);
        BLT = new int[len][n];
        m1 = new long[len][n];
        m2 = new long[len][n];
        m3 = new long[len][n];
        m4 = new long[len][n];
        for (int i = 0; i < n; i++) {
            BLT[0][i] = parent[i];
            getM(gates[i], i);
        }
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < n; j++) {
                int next = BLT[i - 1][j];
                if (next == -1) {
                    BLT[i][j] = -1;
                } else {
                    BLT[i][j] = BLT[i - 1][next];
                    pro(i, j, next);
                }
            }
        }
        int res = 0;
        for (int[] query : queries) {
            res ^= getWays(query);
        }
        return res;
    }

    int[][] BLT;
    long[][] m1;
    long[][] m2;
    long[][] m3;
    long[][] m4;
    int[] depths;
    int len;

    public int getWays(int[] query) {
        int aNode = query[0];
        long[] aArr = getArr(query[1]);
        int bNode = query[2];
        long[] bArr = getArr(query[3]);
        int l = depths[aNode];
        int r = depths[bNode];
        if (l != r) {
            if (l < r) {
                for (int i = len - 1; i >= 0 && r > l; i--) {
                    if (r - (1 << i) >= l) {
                        bArr = proArr(bArr, i, bNode);
                        bNode = BLT[i][bNode];
                        r -= 1 << i;
                    }
                }
            } else {
                for (int i = len - 1; i >= 0 && l > r; i--) {
                    if (l - (1 << i) >= r) {
                        aArr = proArr(aArr, i, aNode);
                        aNode = BLT[i][aNode];
                        l -= 1 << i;
                    }
                }
            }
        }
        if (aNode != bNode) {
            for (int i = len - 1; i >= 0; i--) {
                int aNext = BLT[i][aNode];
                int bNext = BLT[i][bNode];
                if (aNext != bNext) {
                    aArr = proArr(aArr, i, aNode);
                    bArr = proArr(bArr, i, bNode);
                    aNode = aNext;
                    bNode = bNext;
                }
            }
            aArr = proArr(aArr, 0, aNode);
            bArr = proArr(bArr, 0, bNode);
        }
        long aSum = (aArr[0] + aArr[1]) % mod;
        long bSum = (bArr[0] + bArr[1]) % mod;
        int pro = (int) (aSum * bSum % mod);
        return pro;
    }

    public int getDepth(int[] parent) {
        int max = 0;
        for (int i = 0; i < parent.length; i++) {
            max = Math.max(max, dfs(parent, i));
        }
        return max;
    }

    public int dfs(int[] parent, int i) {
        if (depths[i] != -1)
            return depths[i] + 1;
        if (parent[i] == -1) {
            depths[i] = 0;
        } else {
            depths[i] = dfs(parent, parent[i]);
        }
        return depths[i] + 1;
    }

    int mod = 1_000_000_007;

    public void getM(int[] gate, int i) {
        m1[0][i] = gate[0];
        m2[0][i] = gate[2];
        m3[0][i] = gate[2];
        m4[0][i] = gate[1];
    }

    public long[] getArr(int a) {
        long[] res = new long[2];
        res[1 - a] = 1;
        return res;
    }

    public void pro(int i, int j, int next) {
        m1[i][j] = (m1[i - 1][j] * m1[i - 1][next] + m2[i - 1][j] * m3[i - 1][next]) % mod;
        m2[i][j] = (m1[i - 1][j] * m2[i - 1][next] + m2[i - 1][j] * m4[i - 1][next]) % mod;
        m3[i][j] = (m3[i - 1][j] * m1[i - 1][next] + m4[i - 1][j] * m3[i - 1][next]) % mod;
        m4[i][j] = (m3[i - 1][j] * m2[i - 1][next] + m4[i - 1][j] * m4[i - 1][next]) % mod;
    }

    public long[] proArr(long[] a, int i, int j) {
        return new long[] { (a[0] * m1[i][j] + a[1] * m3[i][j]) % mod,
                (a[0] * m2[i][j] + a[1] * m4[i][j]) % mod };
    }
}
