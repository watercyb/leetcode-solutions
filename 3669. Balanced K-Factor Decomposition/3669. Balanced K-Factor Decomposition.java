/*
 * Problem: 3669. Balanced K-Factor Decomposition
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/balanced-k-factor-decomposition/
 * Language: java
 * Date: 2026-05-09
 */

class Solution {
    public int[] minDifference(int n, int k) {
        int bestDiff = Integer.MAX_VALUE;
        int[] best = null;
        if (k == 2) {
            for (int a = 1; a * a <= n; a++) {
                if (n % a == 0) {
                    int b = n / a;
                    int diff = b - a;
                    if (diff < bestDiff) {
                        bestDiff = diff;
                        best = new int[]{a, b};
                    }
                }
            }
        } else if (k == 3) {
            for (int a = 1; a * a * a <= n; a++) {
                if (n % a != 0) continue;
                int m = n / a;
                for (int b = a; b * b <= m; b++) {
                    if (m % b != 0) continue;
                    int c = m / b;
                    int diff = c - a;
                    if (diff < bestDiff) {
                        bestDiff = diff;
                        best = new int[]{a, b, c};
                    }
                }
            }
        } else if (k == 4) {
            for (int a = 1; a * a * a * a <= n; a++) {
                if (n % a != 0) continue;
                int m1 = n / a;
                for (int b = a; b * b * b <= m1; b++) {
                    if (m1 % b != 0) continue;
                    int m2 = m1 / b;
                    for (int c = b; c * c <= m2; c++) {
                        if (m2 % c != 0) continue;
                        int d = m2 / c;
                        int diff = d - a;
                        if (diff < bestDiff) {
                            bestDiff = diff;
                            best = new int[]{a, b, c, d};
                        }
                    }
                }
            }
        } else if (k == 5) {
            for (int a = 1; a * a * a * a * a <= n; a++) {
                if (n % a != 0) continue;
                int m1 = n / a;
                for (int b = a; b * b * b * b <= m1; b++) {
                    if (m1 % b != 0) continue;
                    int m2 = m1 / b;
                    for (int c = b; c * c * c <= m2; c++) {
                        if (m2 % c != 0) continue;
                        int m3 = m2 / c;
                        for (int d = c; d * d <= m3; d++) {
                            if (m3 % d != 0) continue;
                            int e = m3 / d;
                            int diff = e - a;
                            if (diff < bestDiff) {
                                bestDiff = diff;
                                best = new int[]{a, b, c, d, e};
                            }
                        }
                    }
                }
            }
        }

        return best;
    }
}
