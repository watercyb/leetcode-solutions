/*
 * Problem: 3588. Find Maximum Area of a Triangle
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-maximum-area-of-a-triangle/
 * Language: java
 * Date: 2026-05-08
 */

class Solution {
    public long maxArea(int[][] coords) {
        int xMax = Integer.MIN_VALUE;
        int xMin = Integer.MAX_VALUE;
        int yMax = Integer.MIN_VALUE;
        int yMin = Integer.MAX_VALUE;
        HashMap<Integer, int[]> HMX = new HashMap<>();
        HashMap<Integer, int[]> HMY = new HashMap<>();
        for (int[] coord : coords) {
            int x = coord[0];
            int y = coord[1];
            xMax = Math.max(x, xMax);
            xMin = Math.min(x, xMin);
            yMax = Math.max(y, yMax);
            yMin = Math.min(y, yMin);
            if (!HMX.containsKey(x)) {
                int[] pair = { y, y };
                HMX.put(x, pair);
            } else {
                int[] pair = HMX.get(x);
                if (pair[0] > y)
                    pair[0] = y;
                if (pair[1] < y)
                    pair[1] = y;
            }
            if (!HMY.containsKey(y)) {
                int[] pair = { x, x };
                HMY.put(y, pair);
            } else {
                int[] pair = HMY.get(y);
                if (pair[0] > x)
                    pair[0] = x;
                if (pair[1] < x)
                    pair[1] = x;
            }
        }
        long res = 0;
        for (Map.Entry<Integer, int[]> entry : HMX.entrySet()) {
            int k = entry.getKey();
            int[] v = entry.getValue();
            if (v[0] == v[1])
                continue;
            res = Math.max((long) (v[1] - v[0]) * Math.max(xMax - k, k - xMin), res);
        }
        for (Map.Entry<Integer, int[]> entry : HMY.entrySet()) {
            int k = entry.getKey();
            int[] v = entry.getValue();
            if (v[0] == v[1])
                continue;
            res = Math.max((long) (v[1] - v[0]) * Math.max(yMax - k, k - yMin), res);
        }
        if (res == 0)
            return -1;
        return res;
    }
}
