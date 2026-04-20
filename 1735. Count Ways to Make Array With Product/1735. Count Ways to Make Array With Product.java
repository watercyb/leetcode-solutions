/*
 * Problem: 1735. Count Ways to Make Array With Product
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/count-ways-to-make-array-with-product/
 * Language: java
 * Date: 2026-04-20
 */

class Solution {
    public int[] waysToFillArray(int[][] queries) {
        if (arr == null)
            getArr();
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int a = queries[i][0];
            int b = queries[i][1];
            long p = 1;
            while (b > 1) {
                int count = 0;
                int num = arr[b];
                while (b % num == 0) {
                    count++;
                    b /= num;
                }
                p = p * C(a + count - 1, count) % mod;
            }
            res[i] = (int) p;
        }
        return res;
    }

    int mod = 1_000_000_007;
    static int[] arr;
    static int[] f = new int[10011];
    static int[] r = new int[10011];

    public int C(int a, int b) {
        return (int) ((long) f[a] * r[a - b] % mod * r[b] % mod);
    }

    public void getArr() {
        arr = new int[10001];
        arr[1] = 1;
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] != 0)
                continue;
            arr[i] = i;
            for (int j = i * i; j < arr.length; j += i) {
                if (arr[j] == 0)
                    arr[j] = i;
            }
        }
        long pro = 1;
        f[0] = 1;
        r[0] = 1;
        for (int i = 1; i < f.length; i++) {
            pro = pro * i % mod;
            f[i] = (int) pro;
            r[i] = (int) rev(pro);
        }
    }

    public long rev(long a) {
        if (a == 1)
            return a;
        return mod - mod / a * rev(mod % a) % mod;
    }
}
