/*
 * Problem: 757. Set Intersection Size At Least Two
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/set-intersection-size-at-least-two/
 * Language: java
 * Date: 2026-04-08
 */

class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        int a = -1;
        int b = -1;
        int res = 0;
        for (int[] interval : intervals) {
            if (a >= interval[0])
                continue;
            if (b >= interval[0]) {
                if (b == interval[1]) {
                    a = interval[1] - 1;
                } else {
                    a = b;
                    b = interval[1];
                }
                res++;
            } else {
                a = interval[1] - 1;
                b = interval[1];
                res += 2;
            }
        }
        return res;
    }
}
