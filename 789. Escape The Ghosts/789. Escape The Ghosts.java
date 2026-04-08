/*
 * Problem: 789. Escape The Ghosts
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/escape-the-ghosts/
 * Language: java
 * Date: 2026-04-08
 */

class Solution {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int dist = getDist(new int[2], target);
        for (int[] ghost : ghosts) {
            if (getDist(ghost, target) <= dist)
                return false;
        }
        return true;
    }

    public int getDist(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
}
