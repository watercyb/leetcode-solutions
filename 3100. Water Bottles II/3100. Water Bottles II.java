/*
 * Problem: 3100. Water Bottles II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/water-bottles-ii/
 * Language: java
 * Date: 2026-05-03
 */

class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int res = 0;
        while (numBottles >= numExchange) {
            res += numExchange;
            numBottles -= numExchange - 1;
            numExchange++;
        }
        return res + numBottles;
    }
}
