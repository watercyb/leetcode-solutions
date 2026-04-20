/*
 * Problem: 1711. Count Good Meals
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/count-good-meals/
 * Language: java
 * Date: 2026-04-20
 */

class Solution {
    public int countPairs(int[] deliciousness) {
        int max = 0;
        for (int d : deliciousness) {
            max = Math.max(d, max);
        }
        int lim = 1 << (32 - Integer.numberOfLeadingZeros(max));
        int[] counts = new int[lim];
        long res = 0;
        for (int d : deliciousness) {
            for (int i = lim; i >= d && i > 0; i >>= 1) {
                if (i - d < counts.length)
                    res += counts[i - d];
            }
            counts[d]++;
        }
        return (int) (res % 1_000_000_007);
    }
}
