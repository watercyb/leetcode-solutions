/*
 * Problem: 2409. Count Days Spent Together
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/count-days-spent-together/
 * Language: java
 * Date: 2026-04-27
 */

class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        return Math.max(
                Math.min(getDays(leaveAlice), getDays(leaveBob)) - Math.max(getDays(arriveAlice), getDays(arriveBob))
                        + 1,
                0);
    }

    int[] days = { 0, 0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334 };

    public int getDays(String str) {
        return days[(str.charAt(0) - '0') * 10 + str.charAt(1) - '0'] + (str.charAt(3) - '0') * 10 + str.charAt(4)
                - '0';
    }
}
