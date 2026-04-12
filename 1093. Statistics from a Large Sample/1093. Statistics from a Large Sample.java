/*
 * Problem: 1093. Statistics from a Large Sample
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/statistics-from-a-large-sample/
 * Language: java
 * Date: 2026-04-12
 */

class Solution {
    public double[] sampleStats(int[] count) {
        double min = -1, max = 0, mean = 0, median = 0;
        int mode = 0;
        int c = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                if (min == -1)
                    min = i;
                max = i;
                if (count[i] > count[mode])
                    mode = i;
                c += count[i];
                mean += (double) count[i] * i;
            }
        }
        mean /= c;
        int t1 = (c + 1) / 2;
        int t2 = (c + 2) / 2;
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                t1 -= count[i];
                if (t1 <= 0) {
                    median += i;
                    t1 = Integer.MAX_VALUE;
                }
                t2 -= count[i];
                if (t2 <= 0) {
                    median += i;
                    break;
                }
            }
        }
        return new double[] { min, max, mean, median / 2, (double) mode };
    }
}
