/*
 * Problem: 3027. Find the Number of Ways to Place People II
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/find-the-number-of-ways-to-place-people-ii/
 * Language: java
 * Date: 2026-05-03
 */

class Solution {
    public int numberOfPairs(int[][] points) {
        Arrays.sort(points, (a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(b[0], a[0]));
        int res = 0;
        for (int i = 0; i < points.length - 1; i++) {
            int yLim = Integer.MAX_VALUE;
            int j = i + 1;
            if (points[j][0] == points[i][0]) {
                res++;
                yLim = points[j][1];
                j++;
            }
            while (j < points.length && yLim > points[i][1]) {
                if (points[j][1] >= yLim || points[j][1] < points[i][1]) {
                    j++;
                    continue;
                }
                yLim = points[j][1];
                res++;
                j++;
            }
        }
        return res;
    }
}
