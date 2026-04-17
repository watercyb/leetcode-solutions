/*
 * Problem: 1467. Probability of a Two Boxes Having The Same Number of Distinct Balls
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/probability-of-a-two-boxes-having-the-same-number-of-distinct-balls/
 * Language: java
 * Date: 2026-04-17
 */

class Solution {
    public double getProbability(int[] balls) {
        int count = 0;
        for (int ball : balls) {
            count += ball;
        }
        int halfCount = count / 2;
        double[][] counts = new double[count + 1][2 * balls.length + 1];
        counts[0][balls.length] = 1;
        int sum = 0;
        for (int ball : balls) {
            double[][] countsNext = new double[count + 1][2 * balls.length + 1];
            for (int i = Math.min(halfCount, sum); i >= 0; i--) {
                int j = sum - i;
                for (int k = 2 * balls.length - 1; k > 0; k--) {
                    if (counts[i][k] == 0)
                        continue;
                    double temp = counts[i][k];
                    counts[i][k] = 0;
                    countsNext[i][k - 1] += temp * C(j + ball, ball);
                    for (int m = 1; m < ball; m++) {
                        countsNext[i + m][k] += temp * C(i + m, m)
                                * C(j + ball - m, ball - m);
                    }
                    countsNext[i + ball][k + 1] += temp * C(i + ball, ball);
                }
            }
            sum += ball;
            counts = countsNext;
        }
        double a = 0;
        double b = 0;
        for (int i = 0; i <= 2 * balls.length; i++) {
            if (counts[halfCount][i] == 0)
                continue;
            a += counts[halfCount][i];
            if (i == balls.length)
                b += counts[halfCount][i];
        }
        return b / a;
    }

    public long C(int a, int b) {
        long res = 1;
        int pro = a;
        for (int i = 1; i <= b; i++) {
            res = res * pro / i;
            pro--;
        }
        return res;
    }
}
