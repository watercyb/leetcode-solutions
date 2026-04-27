/*
 * Problem: 2406. Divide Intervals Into Minimum Number of Groups
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/divide-intervals-into-minimum-number-of-groups/
 * Language: java
 * Date: 2026-04-27
 */

class Solution {
    public int minGroups(int[][] intervals) {
        int max = 0;
        for (int[] interval : intervals) {
            max = Math.max(interval[1], max);
        }
        int[] arr = new int[max + 2];
        for (int[] interval : intervals) {
            arr[interval[0]]++;
            arr[interval[1] + 1]--;
        }
        int count = 0;
        int res = 0;
        for (int num : arr) {
            count += num;
            res = Math.max(count, res);
        }
        return res;
    }
}
