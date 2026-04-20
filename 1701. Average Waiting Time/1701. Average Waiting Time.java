/*
 * Problem: 1701. Average Waiting Time
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/average-waiting-time/
 * Language: java
 * Date: 2026-04-20
 */

class Solution {
    public double averageWaitingTime(int[][] customers) {
        int prv = 0;
        double sum = 0;
        for (int[] customer : customers) {
            if (customer[0] >= prv) {
                prv = customer[0] + customer[1];
                sum += customer[1];
            } else {
                prv += customer[1];
                sum += prv - customer[0];
            }
        }
        return sum / customers.length;
    }
}
