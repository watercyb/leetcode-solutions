/*
 * Problem: 780. Reaching Points
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/reaching-points/
 * Language: java
 * Date: 2026-04-08
 */

class Solution {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        if (tx == sx && ty == sy)
            return true;
        if (tx < sx || ty < sy)
            return false;
        if (tx > ty) {
            if (ty > sy)
                return reachingPoints(sx, sy, tx % ty, ty);
            return (tx - sx) % ty == 0;
        }
        if (tx < ty) {
            if (tx > sx)
                return reachingPoints(sx, sy, tx, ty % tx);
            return (ty - sy) % tx==0;
        }
        return false;
    }
}
