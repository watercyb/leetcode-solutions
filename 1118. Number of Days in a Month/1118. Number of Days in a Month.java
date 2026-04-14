/*
 * Problem: 1118. Number of Days in a Month
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/number-of-days-in-a-month/
 * Language: java
 * Date: 2026-04-14
 */

class Solution {
    public int numberOfDays(int year, int month) {
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
            return 31;
        if (month == 2) {
            if (year % 400 == 0)
                return 29;
            if (year % 100 == 0)
                return 28;
            if (year % 4 == 0)
                return 29;
            return 28;
        }
        return 30;
    }
}
