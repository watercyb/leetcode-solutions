/*
 * Problem: 539. Minimum Time Difference
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-time-difference/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public int findMinDifference(List<String> timePoints) {
        boolean[] counts = new boolean[1440];
        for (int i = 0; i < timePoints.size(); i++) {
            String str = timePoints.get(i);
            int tmp = (str.charAt(0) - '0') * 600 + (str.charAt(1) - '0') * 60 + (str.charAt(3) - '0') * 10
                    + str.charAt(4) - '0';
            if (counts[tmp])
                return 0;
            counts[tmp] = true;
        }
        int first = -1;
        int last = Integer.MIN_VALUE / 2;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < 1440; i++) {
            if (counts[i]) {
                if (first == -1)
                    first = i;
                res = Math.min(i - last, res);
                last = i;
            }
        }
        return Math.min(first + 1440 - last, res);
    }
}
