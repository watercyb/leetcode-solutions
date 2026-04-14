/*
 * Problem: 1185. Day of the Week
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/day-of-the-week/
 * Language: java
 * Date: 2026-04-14
 */

class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        int a = 1;
        int b = 1;
        int c = 1971;
        int res = 5;
        while (c < year) {
            if ((c % 4 == 0 && c % 100 != 0) || (c % 400 == 0)) {
                res += 366;
            } else {
                res += 365;
            }
            c++;
        }
        while (b < month) {
            if (b == 1 || b == 3 || b == 5 || b == 7 || b == 8 || b == 10 || b == 12) {
                res += 31;
            } else if (b == 2) {
                if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                    res += 29;
                } else {
                    res += 28;
                }
            } else {
                res += 30;
            }
            b++;
        }
        res += day - a;
        switch (res % 7) {
            case 0:
                return "Sunday";
            case 1:
                return "Monday";
            case 2:
                return "Tuesday";
            case 3:
                return "Wednesday";
            case 4:
                return "Thursday";
            case 5:
                return "Friday";
            default:
                return "Saturday";
        }
    }
}
