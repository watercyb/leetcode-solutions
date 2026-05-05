/*
 * Problem: 3208. Alternating Groups II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/alternating-groups-ii/
 * Language: java
 * Date: 2026-05-05
 */

class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int res = 0;
        int l = 0;
        int r = 1;
        int prv = colors[0];
        while (r < colors.length + k - 1 && l < colors.length) {
            int current = colors[r % colors.length];
            if (current == prv) {
                l = r;
            } else if (r - l >= k - 1) {
                res++;
            }
            prv = current;
            r++;
        }
        return res;
    }
}
