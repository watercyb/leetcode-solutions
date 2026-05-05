/*
 * Problem: 3281. Maximize Score of Numbers in Ranges
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximize-score-of-numbers-in-ranges/
 * Language: java
 * Date: 2026-05-05
 */

class Solution {
    public int maxPossibleScore(int[] start, int d) {
        Arrays.sort(start);
        int l = 1;
        int r = Integer.MAX_VALUE;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (!chk(start, d, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l - 1;
    }

    public boolean chk(int[] start, int d, int mid) {
        int prv = start[0];
        for (int i = 1; i < start.length; i++) {
            if (start[i] + d - prv < mid)
                return false;
            prv = Math.max(prv + mid, start[i]);
        }
        return true;
    }
}
