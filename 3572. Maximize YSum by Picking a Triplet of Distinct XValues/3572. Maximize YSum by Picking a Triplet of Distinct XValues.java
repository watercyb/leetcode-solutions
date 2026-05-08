/*
 * Problem: 3572. Maximize Y‑Sum by Picking a Triplet of Distinct X‑Values
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximize-ysum-by-picking-a-triplet-of-distinct-xvalues/
 * Language: java
 * Date: 2026-05-08
 */

class Solution {
    public int maxSumDistinctTriplet(int[] x, int[] y) {
        int a = 0;
        int b = 0;
        int res = 0;
        int max = 0;
        for (int i = 0; i < x.length; i++) {
            if (y[i] > max) {
                max = y[i];
                a = x[i];
            }
        }
        res += max;
        max = 0;
        for (int i = 0; i < x.length; i++) {
            if (y[i] > max && x[i] != a) {
                max = y[i];
                b = x[i];
            }
        }
        if (max == 0)
            return -1;
        res += max;
        max = 0;
        for (int i = 0; i < x.length; i++) {
            if (y[i] > max && x[i] != a && x[i] != b) {
                max = y[i];
            }
        }
        if (max == 0)
            return -1;
        res += max;
        return res;
    }
}
