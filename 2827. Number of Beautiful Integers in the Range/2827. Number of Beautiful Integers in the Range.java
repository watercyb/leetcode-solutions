/*
 * Problem: 2827. Number of Beautiful Integers in the Range
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/number-of-beautiful-integers-in-the-range/
 * Language: java
 * Date: 2026-05-01
 */

class Solution {
    public int numberOfBeautifulIntegers(int low, int high, int k) {
        int a = getCount(low - 1, k);
        int b = getCount(high, k);
        return b - a;
    }

    public int getCount(int num, int k) {
        char[] chrs = String.valueOf(num).toCharArray();
        int n = chrs.length;
        int[][] DP = new int[2 * n + 1][k];
        int rem = 0;
        int diff = n;
        boolean isFirst = true;
        for (char chr : chrs) {
            chr -= '0';
            int[][] DPNext = new int[DP.length][k];
            rem *= 10;
            if (!isFirst) {
                for (int i = 1; i <= 9; i++) {
                    int d = n + (i % 2) * 2 - 1;
                    int r = i % k;
                    DPNext[d][r]++;
                }
                for (int i = 0; i < chr; i++) {
                    int d = diff + (i % 2) * 2 - 1;
                    int r = (rem + i) % k;
                    DPNext[d][r]++;
                }
            } else {
                for (int i = 1; i < chr; i++) {
                    int d = diff + (i % 2) * 2 - 1;
                    int r = (rem + i) % k;
                    DPNext[d][r]++;
                }
            }
            rem = (rem + chr) % k;
            diff += (chr % 2) * 2 - 1;
            for (int i = 0; i < DP.length; i++) {
                for (int j = 0; j < k; j++) {
                    if (DP[i][j] == 0)
                        continue;
                    for (int l = 0; l <= 9; l++) {
                        DPNext[i + (l % 2) * 2 - 1][(j * 10 + l) % k] += DP[i][j];
                    }
                }
            }
            DP = DPNext;
            isFirst = false;
        }
        if (diff == n && rem == 0)
            DP[n][0]++;
        return DP[n][0];
    }
}
