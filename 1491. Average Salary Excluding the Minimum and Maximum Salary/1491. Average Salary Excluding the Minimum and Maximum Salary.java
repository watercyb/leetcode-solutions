/*
 * Problem: 1491. Average Salary Excluding the Minimum and Maximum Salary
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/average-salary-excluding-the-minimum-and-maximum-salary/
 * Language: java
 * Date: 2026-04-17
 */

class Solution {
    public double average(int[] salary) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        double sum = 0;
        for (int s : salary) {
            min = Math.min(s, min);
            max = Math.max(s, max);
            sum += s;
        }
        return (sum - min - max) / (salary.length - 2);
    }
}
