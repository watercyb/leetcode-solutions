/*
 * Problem: 1274. Number of Ships in a Rectangle
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/number-of-ships-in-a-rectangle/
 * Language: java
 * Date: 2026-04-15
 */

/**
 * // This is Sea's API interface.
 * // You should not implement it, or speculate about its implementation
 * class Sea {
 * public boolean hasShips(int[] topRight, int[] bottomLeft);
 * }
 */

class Solution {
    public int countShips(Sea sea, int[] topRight, int[] bottomLeft) {
        return sep(sea, topRight, bottomLeft);
    }

    public int sep(Sea sea, int[] topRight, int[] bottomLeft) {
        if (topRight[0] < bottomLeft[0] || topRight[1] < bottomLeft[1] || !sea.hasShips(topRight, bottomLeft))
            return 0;
        if (topRight[0] == bottomLeft[0] && topRight[1] == bottomLeft[1])
            return 1;
        int midX = (bottomLeft[0] + topRight[0]) / 2;
        int midY = (bottomLeft[1] + topRight[1]) / 2;
        return sep(sea, topRight, new int[] { midX + 1, midY + 1 })
                + sep(sea, new int[] { midX, topRight[1] }, new int[] { bottomLeft[0], midY + 1 })
                + sep(sea, new int[] { topRight[0], midY }, new int[] { midX + 1, bottomLeft[1] })
                + sep(sea, new int[] { midX, midY }, bottomLeft);
    }
}
