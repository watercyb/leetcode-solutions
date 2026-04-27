/*
 * Problem: 2469. Convert the Temperature
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/convert-the-temperature/
 * Language: java
 * Date: 2026-04-27
 */

class Solution {
    public double[] convertTemperature(double celsius) {
        return new double[] { celsius + 273.15, celsius * 1.8 + 32 };
    }
}
