/*
 * Problem: 3796. Find Maximum Value in a Constrained Sequence
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-maximum-value-in-a-constrained-sequence/
 * Language: java
 * Date: 2026-05-10
 */

class Solution {
    public int findMaxVal(int n, int[][] restrictions, int[] diff) {
        int[] lims = new int[n];
        Arrays.fill(lims, Integer.MAX_VALUE);
        lims[0] = 0;
        for (int[] restriction : restrictions) {
            lims[restriction[0]] = restriction[1];
        }
        for (int i = 0; i < n - 1; i++) {
            lims[i + 1] = Math.min(lims[i + 1], lims[i] + diff[i]);
        }
        for (int i = n - 2; i >= 0; i--) {
            lims[i] = Math.min(lims[i], lims[i + 1] + diff[i]);
        }
        int res = 0;
        for (int lim : lims) {
            res = Math.max(res, lim);
        }
        return res;
    }
}
