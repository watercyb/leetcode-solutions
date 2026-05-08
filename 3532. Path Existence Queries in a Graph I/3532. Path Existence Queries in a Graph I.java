/*
 * Problem: 3532. Path Existence Queries in a Graph I
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/path-existence-queries-in-a-graph-i/
 * Language: java
 * Date: 2026-05-08
 */

class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int[] arr = new int[n];
        for (int i = 1; i < n; i++) {
            if (nums[i] - nums[i - 1] <= maxDiff) {
                arr[i] = arr[i - 1];
            } else {
                arr[i] = arr[i - 1] + 1;
            }
        }
        boolean[] res = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            res[i] = arr[queries[i][0]] == arr[queries[i][1]];
        }
        return res;
    }
}
