/*
 * Problem: 1182. Shortest Distance to Target Color
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/shortest-distance-to-target-color/
 * Language: java
 * Date: 2026-04-14
 */

class Solution {
    public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
        int[][] mins = new int[3][colors.length];
        for (int i = 0; i < 3; i++) {
            int idx = Integer.MIN_VALUE / 2;
            for (int j = 0; j < colors.length; j++) {
                if (colors[j] == i + 1)
                    idx = j;
                mins[i][j] = j - idx;
            }
        }
        for (int i = 0; i < 3; i++) {
            int idx = Integer.MAX_VALUE / 2;
            for (int j = colors.length - 1; j >= 0; j--) {
                if (colors[j] == i + 1)
                    idx = j;
                mins[i][j] = Math.min(mins[i][j], idx - j);
            }
        }
        int lim = Integer.MAX_VALUE / 3;
        List<Integer> res = new ArrayList<>();
        for (int[] query : queries) {
            if (mins[query[1] - 1][query[0]] >= lim) {
                res.add(-1);
            } else {
                res.add(mins[query[1] - 1][query[0]]);
            }
        }
        return res;
    }
}
