/*
 * Problem: 120. Triangle
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/triangle/
 * Language: java
 * Date: 2026-03-25
 */

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] DP = new int[triangle.getLast().size() + 1];
        for (int i = triangle.size() - 1; i >= 0; i--) {
            List<Integer> list = triangle.get(i);
            for (int j = 0; j < list.size(); j++) {
                DP[j] = Math.min(DP[j], DP[j + 1]) + list.get(j);
            }
        }
        return DP[0];
    }
}
