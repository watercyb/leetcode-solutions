/*
 * Problem: 1029. Two City Scheduling
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/two-city-scheduling/
 * Language: java
 * Date: 2026-04-11
 */

class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int[] arr = new int[costs.length];
        int sum = 0;
        for (int i = 0; i < costs.length; i++) {
            arr[i] = costs[i][0] - costs[i][1];
            sum += costs[i][0] + costs[i][1];
        }
        Arrays.sort(arr);
        for (int i = 0; i < arr.length / 2; i++) {
            sum += arr[i];
        }
        for (int i = arr.length / 2; i < arr.length; i++) {
            sum -= arr[i];
        }
        return sum / 2;
    }
}
