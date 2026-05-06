/*
 * Problem: 3337. Total Characters in String After Transformations II
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/total-characters-in-string-after-transformations-ii/
 * Language: java
 * Date: 2026-05-06
 */

class Solution {
    public int lengthAfterTransformations(String s, int t, List<Integer> nums) {
        long[][] m = new long[26][26];
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 1; j <= nums.get(i); j++) {
                m[i][(i + j) % 26]++;
            }
        }
        long[] arr = new long[26];
        for (char chr : s.toCharArray()) {
            arr[chr - 'a']++;
        }
        arr = qPow(arr, m, t);
        long res = 0;
        for (long num : arr) {
            res += num;
        }
        return (int) (res % mod);
    }

    int mod = 1_000_000_007;

    public long[] qPow(long[] a, long[][] b, int t) {
        while (t > 0) {
            if (t % 2 == 1)
                a = pro(a, b);
            b = pow(b);
            t /= 2;
        }
        return a;
    }

    public long[][] pow(long[][] a) {
        long[][] res = new long[a.length][a[0].length];
        for (int i = 0; i < res.length; i++) {
            for (int k = 0; k < res.length; k++) {
                if (a[i][k] == 0)
                    continue;
                for (int j = 0; j < res.length; j++) {
                    res[i][j] = (res[i][j] + a[i][k] * a[k][j]) % mod;
                }
            }
        }
        return res;
    }

    public long[] pro(long[] a, long[][] b) {
        long[] res = new long[a.length];
        for (int j = 0; j < res.length; j++) {
            if (a[j] == 0)
                continue;
            for (int i = 0; i < res.length; i++) {
                res[i] = (res[i] + a[j] * b[j][i]) % mod;
            }
        }
        return res;
    }
}
