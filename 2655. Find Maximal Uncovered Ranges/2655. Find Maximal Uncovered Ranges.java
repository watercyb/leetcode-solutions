/*
 * Problem: 2655. Find Maximal Uncovered Ranges
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-maximal-uncovered-ranges/
 * Language: java
 * Date: 2026-04-29
 */

class Solution {
    public int[][] findMaximalUncoveredRanges(int n, int[][] ranges) {
        Arrays.sort(ranges, (a, b) -> a[0] - b[0]);
        List<int[]> list = new ArrayList<>();
        int lim = 0;
        for (int i = 0; i < ranges.length; i++) {
            if (ranges[i][0] > lim)
                list.add(new int[] { lim, ranges[i][0] - 1 });
            lim = Math.max(ranges[i][1] + 1, lim);
        }
        if (lim < n)
            list.add(new int[] { lim, n - 1 });
        int[][] res = new int[list.size()][];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
