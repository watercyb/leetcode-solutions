/*
 * Problem: 1272. Remove Interval
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/remove-interval/
 * Language: java
 * Date: 2026-04-15
 */

class Solution {
    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        List<List<Integer>> res = new ArrayList<>();
        for (int[] interval : intervals) {
            if (interval[0] < toBeRemoved[0])
                res.add(Arrays.asList(interval[0], Math.min(interval[1], toBeRemoved[0])));
            if (interval[1] > toBeRemoved[1])
                res.add(Arrays.asList(Math.max(interval[0], toBeRemoved[1]), interval[1]));
        }
        return res;
    }
}
