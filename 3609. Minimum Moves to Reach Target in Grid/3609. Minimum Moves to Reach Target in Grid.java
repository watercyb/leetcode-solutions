/*
 * Problem: 3609. Minimum Moves to Reach Target in Grid
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimum-moves-to-reach-target-in-grid/
 * Language: java
 * Date: 2026-05-09
 */

class Solution {
    public int minMoves(int sx, int sy, int tx, int ty) {
        int res = 0;
        while (tx >= sx && ty >= sy) {
            if (tx == sx && ty == sy)
                return res;
            if (tx > ty) {
                if (tx - ty <= ty) {
                    tx -= ty;
                    res++;
                } else if ((tx & 1) == 0) {
                    tx /= 2;
                    res++;
                } else {
                    return -1;
                }
            } else if (tx < ty) {
                if (ty - tx <= tx) {
                    ty -= tx;
                    res++;
                } else if ((ty & 1) == 0) {
                    ty /= 2;
                    res++;
                } else {
                    return -1;
                }
            } else {
                if (sx == 0) {
                    res++;
                    if (ty == sy)
                        return res;
                    while (ty > 0 && ty % 2 == 0) {
                        res++;
                        ty /= 2;
                        if (ty == sy)
                            return res;
                    }
                } else if (sy == 0) {
                    res++;
                    if (tx == sx)
                        return res;
                    while (tx > 0 && tx % 2 == 0) {
                        res++;
                        tx /= 2;
                        if (tx == sx)
                            return res;
                    }
                }
                return -1;
            }
        }
        return -1;
    }
}
