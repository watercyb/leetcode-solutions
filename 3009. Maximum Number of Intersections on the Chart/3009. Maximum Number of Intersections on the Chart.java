/*
 * Problem: 3009. Maximum Number of Intersections on the Chart
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/maximum-number-of-intersections-on-the-chart/
 * Language: java
 * Date: 2026-05-03
 */

class Solution {
    public int maxIntersectionCount(int[] y) {
        int[] start = new int[y.length - 1];
        int[] end = new int[y.length - 1];
        int firstEqualsLast = -1;
        int countEdgeEqualsFirst = 0;
        if (y[0] == y[y.length - 1])
            firstEqualsLast = y[0];
        int[] prv = { y[0], y[0] };
        for (int i = 0; i < y.length - 1; i++) {
            if (y[i + 1] > y[i]) {
                start[i] = y[i];
                end[i] = y[i + 1];
            } else {
                start[i] = y[i + 1];
                end[i] = y[i];
            }
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int res = 0;
        int count = 0;
        int l = 0;
        int r = 0;
        while (l < start.length) {
            if (start[l] < end[r]) {
                int current = start[l];
                while (l < start.length && start[l] == current) {
                    count++;
                    l++;
                }
                res = Math.max(count, res);
            } else if (start[l] > end[r]) {
                int current = end[r];
                while (end[r] == current) {
                    count--;
                    r++;
                }
            } else {
                int current = start[l];
                if (current == firstEqualsLast) {
                    int currentCount = count;
                    while (l < start.length && start[l] == current) {
                        count++;
                        l++;
                    }
                    while (end[r] == current) {
                        count--;
                        r++;
                    }
                    if (count == currentCount) {
                        res = Math.max(count + 1, res);
                    } else {
                        res = Math.max(count, res);
                    }
                } else {
                    while (l < start.length && start[l] == current) {
                        count++;
                        l++;
                    }
                    while (end[r] == current) {
                        count--;
                        r++;
                    }
                    res = Math.max(count, res);
                }
            }
        }
        return res;
    }
}
