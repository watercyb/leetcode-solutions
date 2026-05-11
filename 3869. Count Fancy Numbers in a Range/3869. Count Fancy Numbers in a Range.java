/*
 * Problem: 3869. Count Fancy Numbers in a Range
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/count-fancy-numbers-in-a-range/
 * Language: java
 * Date: 2026-05-11
 */

class Solution {
    public long countFancy(long l, long r) {
        isGoods = new boolean[String.valueOf(r).length() * 9 + 1];
        for (int i = 0; i < isGoods.length; i++) {
            if (chk(i))
                isGoods[i] = true;
        }
        long lI = inc(l - 1);
        long lD = dec(l - 1);
        long rI = inc(r);
        long rD = dec(r);
        return rI + rD - lI - lD;
    }

    boolean[] isGoods;

    public boolean chk(int a) {
        if (a < 10)
            return true;
        int d1 = a % 10;
        a /= 10;
        int d2 = a % 10;
        a /= 10;
        if (d1 < d2) {
            while (a > 0) {
                if (a % 10 <= d2)
                    return false;
                d2 = a % 10;
                a /= 10;
            }
            return true;
        } else if (d1 > d2) {
            while (a > 0) {
                if (a % 10 >= d2)
                    return false;
                d2 = a % 10;
                a /= 10;
            }
            return true;
        } else {
            return false;
        }
    }

    public long inc(long n) {
        if (n == 0)
            return 0;
        char[] chrs = String.valueOf(n).toCharArray();
        long[][] DP = new long[10][isGoods.length];
        long[] DP1 = new long[isGoods.length];
        boolean isGood = true;
        int sum = 0;
        int prv = -1;
        for (int i = 0; i < chrs.length; i++) {
            for (int j = 9; j >= 0; j--) {
                for (int k = isGoods.length - 1; k >= 0; k--) {
                    long temp = DP[j][k];
                    DP[j][k] = 0;
                    if (temp == 0)
                        continue;
                    for (int jNext = j + 1; jNext <= 9; jNext++) {
                        int kNext = k + jNext;
                        DP[jNext][kNext] = DP[jNext][kNext] + temp;
                    }
                }
            }
            int idx = chrs[i] - '0';
            if (isGood) {
                int lim = i == 0 ? 1 : prv + 1;
                for (int j = lim; j < idx; j++) {
                    DP[j][sum + j] = (DP[j][sum + j] + 1);
                }
            }
            if (idx <= prv) {
                isGood = false;
            }
            prv = idx;

            for (int j = isGoods.length - 1; j >= 0; j--) {
                long temp = DP1[j];
                DP1[j] = 0;
                if (temp == 0)
                    continue;
                for (int k = 0; k <= 9; k++) {
                    DP1[j + k] = (DP1[j + k] + temp);
                }
            }
            int lim = i == 0 ? 1 : 0;
            for (int j = lim; j < idx; j++) {
                DP1[sum + j] = (DP1[sum + j] + 1);
            }
            sum += idx;

            if (i > 0) {
                for (int j = 1; j <= 9; j++) {
                    DP[j][j] = (DP[j][j] + 1);
                    DP1[j] = (DP1[j] + 1);
                }
            }
        }
        long res = 0;
        for (int i = 0; i < DP.length; i++) {
            for (int j = 0; j < DP[0].length; j++) {
                if (!isGoods[j])
                    res += DP[i][j];
            }
        }
        for (int i = 0; i < DP1.length; i++) {
            if (isGoods[i])
                res += DP1[i];
        }
        if (isGood || isGoods[sum])
            res++;
        return res;
    }

    public long dec(long n) {
        if (n <= 9)
            n = 10;
        char[] chrs = String.valueOf(n).toCharArray();
        long[][] DP = new long[10][isGoods.length];
        long[] DP1 = new long[isGoods.length];
        boolean isGood = true;
        int sum = 0;
        int prv = 10;
        for (int i = 0; i < chrs.length; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int k = 0; k < isGoods.length; k++) {
                    long temp = DP[j][k];
                    DP[j][k] = 0;
                    if (temp == 0)
                        continue;
                    for (int jNext = j - 1; jNext >= 0; jNext--) {
                        int kNext = k + jNext;
                        DP[jNext][kNext] = (DP[jNext][kNext] + temp);
                    }
                }
            }
            int idx = chrs[i] - '0';
            if (isGood) {
                int lim = i == 0 ? 1 : 0;
                for (int j = lim; j < Math.min(prv, idx); j++) {
                    DP[j][sum + j] = (DP[j][sum + j] + 1);
                }
            }
            if (idx >= prv) {
                isGood = false;
            }
            prv = idx;

            for (int j = isGoods.length - 1; j >= 0; j--) {
                long temp = DP1[j];
                DP1[j] = 0;
                if (temp == 0)
                    continue;
                for (int k = 0; k <= 9; k++) {
                    DP1[j + k] = (DP1[j + k] + temp);
                }
            }
            int lim = i == 0 ? 1 : 0;
            for (int j = lim; j < idx; j++) {
                DP1[sum + j] = (DP1[sum + j] + 1);
            }
            sum += idx;

            if (i > 0) {
                for (int j = 1; j <= 9; j++) {
                    DP[j][j] = (DP[j][j] + 1);
                    DP1[j] = (DP1[j] + 1);
                }
            }
        }
        long res = 0;
        for (int i = 0; i < DP.length; i++) {
            for (int j = 0; j < DP[0].length; j++) {
                if (!isGoods[j])
                    res += DP[i][j];
            }
        }
        if (isGood && !isGoods[sum])
            res++;
        return res;
    }
}
