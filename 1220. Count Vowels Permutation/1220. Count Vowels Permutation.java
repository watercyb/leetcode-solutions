/*
 * Problem: 1220. Count Vowels Permutation
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/count-vowels-permutation/
 * Language: java
 * Date: 2026-04-15
 */

class Solution {
    int mod = 1_000_000_007;

    public int countVowelPermutation(int n) {
        int[][] ori = { { 1, 1, 1, 1, 1 } };
        int[][] mat = { { 0, 1, 1, 0, 1 },
                { 1, 0, 1, 0, 0 },
                { 0, 1, 0, 1, 0 },
                { 0, 0, 1, 0, 0 },
                { 0, 0, 1, 1, 0 } };
        n--;
        while (n > 0) {
            if (n % 2 == 1) {
                ori = pro(ori, mat);
            }
            mat = pro(mat, mat);
            n /= 2;
        }
        long res = 0;
        for (int i = 0; i < 5; i++) {
            res += ori[0][i];
        }
        return (int) (res % mod);
    }

    public int[][] pro(int[][] a, int[][] b) {
        int[][] res = new int[a.length][b[0].length];
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                long tmp = 0;
                for (int k = 0; k < res[0].length; k++) {
                    tmp += (long) a[i][k] * b[k][j];
                }
                res[i][j] = (int) (tmp % mod);
            }
        }
        return res;
    }
}
