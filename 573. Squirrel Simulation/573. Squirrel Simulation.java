/*
 * Problem: 573. Squirrel Simulation
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/squirrel-simulation/
 * Language: java
 * Date: 2026-04-04
 */

class Solution {
    public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int[] nut : nuts) {
            int dist1 = getDist(nut, tree);
            int dist2 = getDist(nut, squirrel);
            sum += 2 * dist1;
            min = Math.min(min, dist2 - dist1);
        }
        return sum + min;
    }

    public int getDist(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
}
