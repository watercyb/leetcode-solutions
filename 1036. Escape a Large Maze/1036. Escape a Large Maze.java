/*
 * Problem: 1036. Escape a Large Maze
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/escape-a-large-maze/
 * Language: java
 * Date: 2026-04-11
 */

class Solution {
    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        long s = 1000001l * source[1] + source[0];
        long t = 1000001l * target[1] + target[0];
        HashSet<Long> HS = new HashSet<>();
        for (int[] pair : blocked) {
            HS.add(1000001l * pair[1] + pair[0]);
        }
        int a = DFS(HS, s, s, t, blocked.length);
        if (a == -1)
            return false;
        if (a == 1)
            return true;
        HS = new HashSet<>();
        for (int[] pair : blocked) {
            HS.add(1000001l * pair[1] + pair[0]);
        }
        int b = DFS(HS, t, t, s, blocked.length);
        if (b == -1)
            return false;
        return true;
    }

    public int DFS(HashSet<Long> HS, long source, long current, long target, int lim) {
        if (current == target)
            return 1;
        long x = current % 1000001;
        long y = current / 1000001;
        if (Math.abs(current % 1000001 - source % 1000001) >= lim
                || Math.abs(current / 1000001 - source / 1000001) >= lim)
            return 0;
        if (current % 1000001 > 0) {
            if (HS.add(current - 1)) {
                int res = DFS(HS, source, current - 1, target, lim);
                if (res != -1)
                    return res;
            }
        }
        if (current % 1000001 < 999999) {
            if (HS.add(current + 1)) {
                int res = DFS(HS, source, current + 1, target, lim);
                if (res != -1)
                    return res;
            }
        }
        if (current / 1000001 > 0) {
            if (HS.add(current - 1000001)) {
                int res = DFS(HS, source, current - 1000001, target, lim);
                if (res != -1)
                    return res;
            }
        }
        if (current / 1000001 < 999999) {
            if (HS.add(current + 1000001)) {
                int res = DFS(HS, source, current + 1000001, target, lim);
                if (res != -1)
                    return res;
            }
        }
        return -1;
    }
}
