/*
 * Problem: 1610. Maximum Number of Visible Points
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/maximum-number-of-visible-points/
 * Language: java
 * Date: 2026-04-19
 */

class Solution {
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        List<Double> Li = new ArrayList<>();
        int l = points.size();
        double[] angles = new double[2 * l];
        int[] pos = new int[] { location.get(0), location.get(1) };
        int res = 0;
        for (int i = 0; i < l; i++) {
            List<Integer> tmp = points.get(i);
            double x = tmp.get(0) - pos[0];
            double y = tmp.get(1) - pos[1];
            if (x == 0 && y == 0) {
                res++;
                angles[i] = Integer.MAX_VALUE;
                angles[i + l] = Integer.MAX_VALUE;
            } else {
                angles[i] = Math.atan2(y, x);
                if (angles[i] < 0)
                    angles[i] += 2 * Math.PI;
                angles[i + l] = angles[i] + 2 * Math.PI;
            }
        }
        Arrays.sort(angles);
        double range = Math.PI * angle / 180;
        // System.out.println(Arrays.toString(angles));
        int max = 0;
        int j = 0;
        for (int i = 0; i < angles.length && angles[i] < Integer.MAX_VALUE; i++) {
            while (angles[i] - angles[j] > range) {
                j++;
            }
            max = Math.max(i - j + 1, max);
        }

        return res + max;
    }
}
