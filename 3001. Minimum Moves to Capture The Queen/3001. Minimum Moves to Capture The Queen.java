/*
 * Problem: 3001. Minimum Moves to Capture The Queen
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-moves-to-capture-the-queen/
 * Language: java
 * Date: 2026-05-03
 */

class Solution {
    public int minMovesToCaptureTheQueen(int a, int b, int c, int d, int e, int f) {
        if (Math.abs(c - e) == Math.abs(d - f)) {
            if (chk(a, b, c, d, e, f)) {
                return 2;
            } else {
                return 1;
            }
        } else if (a == e) {
            if (a == c && Math.min(b, f) < d && d < Math.max(b, f)) {
                return 2;
            } else {
                return 1;
            }
        } else if (b == f) {
            if (b == d && Math.min(a, e) < c && c < Math.max(a, e)) {
                return 2;
            } else {
                return 1;
            }
        } else {
            return 2;
        }
    }

    public boolean chk(int a, int b, int c, int d, int e, int f) {
        int x1 = Math.min(c, e);
        int x2 = Math.max(c, e);
        int y1 = Math.min(d, f);
        int y2 = Math.max(d, f);
        return Math.abs(a - e) == Math.abs(b - f) && x1 < a && a < x2 && y1 < b && b < y2;
    }
}
