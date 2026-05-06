/*
 * Problem: 3343. Count Number of Balanced Permutations
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/count-number-of-balanced-permutations/
 * Language: java
 * Date: 2026-05-06
 */

class Solution {
    public int countBalancedPermutations(String num) {
        int[] counts = new int[10];
        for (char chr : num.toCharArray()) {
            counts[chr - '0']++;
            totalSum += chr - '0';
        }
        if (totalSum % 2 == 1)
            return 0;
        totalCount = num.length();
        meme = new Long[10][totalCount / 2 + 2][totalSum / 2 + 1];
        totalSum /= 2;
        return (int) dfs(counts, 0, 0, 0, 0, 0);
    }

    int mod = 1_000_000_007;

    int totalSum = 0;
    int totalCount = 0;

    Long[][][] meme;
    static long[][] memeC = new long[41][41];

    public long dfs(int[] counts, int i, int n1, int n2, int sum1, int sum2) {
        if (i == counts.length) {
            return 1;
        } else {
            if (meme[i][n1][sum1] != null)
                return meme[i][n1][sum1];
            int n1Current = n1;
            int sum1Current = sum1;
            long res = 0;
            n1 += counts[i];
            sum1 += counts[i] * i;
            for (int j = 0; j <= counts[i]; j++) {
                if (sum1 <= totalSum && 2 * n1 <= totalCount + 1) {
                    if (sum2 > totalSum || 2 * n2 > totalCount)
                        break;
                    long r = dfs(counts, i + 1, n1, n2, sum1, sum2);
                    if (r != 0)
                        res = (res + r * C(n1, counts[i] - j) % mod * C(n2, j)) % mod;
                }
                n1--;
                n2++;
                sum1 -= i;
                sum2 += i;
            }
            return meme[i][n1Current][sum1Current] = res;
        }
    }

    public long C(int a, int b) {
        if (a - b < b)
            b = a - b;
        if (memeC[a][b] != 0)
            return memeC[a][b];
        int aCurrent = a;
        long res = 1;
        long div = 1;
        for (int i = 1; i <= b; i++) {
            res = res * a % mod;
            div = div * i % mod;
            a--;
        }
        return memeC[aCurrent][b] = res * rev(div) % mod;
    }

    public long rev(long a) {
        if (a == 1)
            return 1;
        return mod - mod / a * rev(mod % a) % mod;
    }
}
