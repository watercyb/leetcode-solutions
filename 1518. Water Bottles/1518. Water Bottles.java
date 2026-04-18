/*
 * Problem: 1518. Water Bottles
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/water-bottles/
 * Language: java
 * Date: 2026-04-18
 */

class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int res = 0;
        int prv = 0;
        while (numBottles + prv >= numExchange) {
            res += numBottles;
            int sum = numBottles + prv;
            numBottles = sum / numExchange;
            prv = sum % numExchange;
        }
        return res + numBottles;
    }
}
