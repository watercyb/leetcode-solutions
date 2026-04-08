/*
 * Problem: 746. Min Cost Climbing Stairs
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/min-cost-climbing-stairs/
 * Language: java
 * Date: 2026-04-08
 */

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] DP=new int[cost.length+1];
        for (int i=2;i<=cost.length;i++) {
            DP[i]=Math.min(DP[i-1]+cost[i-1],DP[i-2]+cost[i-2]);
        }
        return DP[cost.length];
    }
}
