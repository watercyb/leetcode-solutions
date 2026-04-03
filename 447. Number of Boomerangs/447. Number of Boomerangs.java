/*
 * Problem: 447. Number of Boomerangs
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/number-of-boomerangs/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int res = 0;
        HashMap<Integer, Integer> HM = new HashMap<>(points.length, 0.99f);
        for (int i = 0; i < points.length; i++) {
            HM.clear();
            for (int j = 0; j < points.length; j++) {
                int dist = getDist(points[i], points[j]);
                int count = HM.getOrDefault(dist, 0);
                res += count;
                HM.put(dist, count + 1);
            }
        }
        return res * 2;
    }

    public int getDist(int[] a, int[] b) {
        return (a[0] - b[0]) * (a[0] - b[0]) + (a[1] - b[1]) * (a[1] - b[1]);
    }
}
