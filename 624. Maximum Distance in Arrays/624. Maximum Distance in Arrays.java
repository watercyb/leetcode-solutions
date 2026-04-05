/*
 * Problem: 624. Maximum Distance in Arrays
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-distance-in-arrays/
 * Language: java
 * Date: 2026-04-05
 */

class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        List<Integer> tmp = arrays.get(0);
        int[] min = { Integer.MAX_VALUE, Integer.MAX_VALUE };
        int[] max = { Integer.MIN_VALUE, Integer.MIN_VALUE };
        boolean isSameGroup = false;
        for (int i = 0; i < arrays.size(); i++) {
            tmp = arrays.get(i);
            int a = tmp.get(0);
            int b = tmp.get(tmp.size() - 1);
            boolean isMax = false;
            if (a < min[0]) {
                isSameGroup = false;
                isMax = true;
                min[1] = min[0];
                min[0] = a;
            } else if (a < min[1]) {
                min[1] = a;
            }
            if (b > max[0]) {
                if (isMax) {
                    isSameGroup = true;
                } else {
                    isSameGroup = false;
                }
                max[1] = max[0];
                max[0] = b;
            } else if (b > max[1]) {
                max[1] = b;
            }
        }
        if (!isSameGroup)
            return max[0] - min[0];
        return Math.max(max[0] - min[1], max[1] - min[0]);
    }
}
