/*
 * Problem: 3235. Check if the Rectangle Corner Is Reachable
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/check-if-the-rectangle-corner-is-reachable/
 * Language: java
 * Date: 2026-05-05
 */

class Solution {
    public boolean canReachCorner(int xCorner, int yCorner, int[][] circles) {
        int[] edges = new int[circles.length];
        boolean[] isInside = new boolean[circles.length];
        for (int i = 0; i < circles.length; i++) {
            long x = circles[i][0];
            long y = circles[i][1];
            long r = circles[i][2];
            isInside[i] = (x <= xCorner && y <= yCorner);
            if (x * x + y * y <= r * r || (x - xCorner) * (x - xCorner) + (y + yCorner) * (y + yCorner) <= r * r)
                return false;
            if ((y - r <= 0 && y + r >= 0 && x <= xCorner) || (x + r >= xCorner && x - r <= xCorner && y <= yCorner))
                edges[i] = 1;
            if ((x - r <= 0 && x + r >= 0 && y <= yCorner) || (y + r >= yCorner && y - r <= yCorner && x <= xCorner))
                edges[i] += 2;
            if (edges[i] == 3)
                return false;
        }
        // System.out.println(links);
        // System.out.println(Arrays.toString(edges));
        boolean[] seens = new boolean[circles.length];
        for (int i = 0; i < circles.length; i++) {
            if (!seens[i] && dfs(circles, seens, edges, isInside, xCorner, yCorner, i) == 3)
                return false;
        }
        return true;
    }

    public int dfs(int[][] circles, boolean[] seens, int[] edges, boolean[] isInside, int xCorner, int yCorner, int i) {
        seens[i] = true;
        int res = edges[i];
        long x = circles[i][0];
        long y = circles[i][1];
        long r = circles[i][2];
        for (int j = 0; j < circles.length; j++) {
            if (seens[j])
                continue;
            long x1 = circles[j][0];
            long y1 = circles[j][1];
            long r1 = circles[j][2];
            long dX = x - x1;
            long dY = y - y1;
            long dR = r + r1;
            if (dX * dX + dY * dY <= dR * dR && (isInside[i] || isInside[j] ||
                    (x + x1 <= 2 * xCorner && y + y1 <= 2 * yCorner))) {
                res |= dfs(circles, seens, edges, isInside, xCorner, yCorner, j);
                if (res == 3)
                    break;
            }
        }
        return res;
    }
}
