/*
 * Problem: 986. Interval List Intersections
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/interval-list-intersections/
 * Language: java
 * Date: 2026-04-10
 */

class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> res = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < firstList.length && j < secondList.length) {
            int start = Math.max(firstList[i][0], secondList[j][0]);
            int end = Math.min(firstList[i][1], secondList[j][1]);
            if (start <= end)
                res.add(new int[] { start, end });
            if (firstList[i][1] == end)
                i++;
            if (secondList[j][1] == end)
                j++;
        }
        return res.toArray(new int[res.size()][2]);
    }
}
