/*
 * Problem: 551. Student Attendance Record I
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/student-attendance-record-i/
 * Language: java
 * Date: 2026-04-04
 */

class Solution {
    public boolean checkRecord(String s) {
        int countA = 0;
        int countL = 0;
        for (char chr : s.toCharArray()) {
            if (chr == 'A')
                if (++countA == 2)
                    return false;
            if (chr == 'L') {
                if (++countL == 3)
                    return false;
            } else {
                countL = 0;
            }
        }
        return true;
    }
}
