/*
 * Problem: 1154. Day of the Year
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/day-of-the-year/
 * Language: java
 * Date: 2026-04-14
 */

class Solution {
    public int dayOfYear(String date) {
        int[] a = { 0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334 };
        int[] b = { 0, 31, 60, 91, 121, 152, 182, 213, 244, 274, 305, 335 };
        int y = (date.charAt(0) - '0') * 1000 + (date.charAt(1) - '0') * 100 + (date.charAt(2) - '0') * 10
                + date.charAt(3) - '0';
        int m = (date.charAt(5) - '0') * 10 + date.charAt(6) - '0';
        int d = (date.charAt(8) - '0') * 10 + date.charAt(9) - '0';
        if ((y % 100 != 0 && y % 4 == 0) || y % 400 == 0)
            return b[m - 1] + d;
        return a[m - 1] + d;
    }
}
