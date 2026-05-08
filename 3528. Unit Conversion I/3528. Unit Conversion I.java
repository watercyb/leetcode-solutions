/*
 * Problem: 3528. Unit Conversion I
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/unit-conversion-i/
 * Language: java
 * Date: 2026-05-08
 */

class Solution {
    public int[] baseUnitConversions(int[][] conversions) {
        int mod = 1_000_000_007;
        int[] res = new int[conversions.length + 1];
        res[0] = 1;
        boolean changed = true;
        while (changed) {
            changed = false;
            for (int i = 0; i < conversions.length; i++) {
                if (res[conversions[i][0]] != 0 && res[conversions[i][1]] == 0) {
                    changed = true;
                    res[conversions[i][1]] = (int) ((long) res[conversions[i][0]] * conversions[i][2] % mod);
                }
            }
            for (int i = conversions.length - 1; i >= 0; i--) {
                if (res[conversions[i][0]] != 0 && res[conversions[i][1]] == 0) {
                    changed = true;
                    res[conversions[i][1]] = (int) ((long) res[conversions[i][0]] * conversions[i][2] % mod);
                }
            }
        }
        return res;
    }
}
