/*
 * Problem: 2446. Determine if Two Events Have Conflict
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/determine-if-two-events-have-conflict/
 * Language: java
 * Date: 2026-04-27
 */

class Solution {
    public boolean haveConflict(String[] event1, String[] event2) {
        int a = getM(event1[0]);
        int b = getM(event1[1]);
        int c = getM(event2[0]);
        int d = getM(event2[1]);
        return !(c > b || d < a);
    }

    public int getM(String str) {
        return ((str.charAt(0) - '0') * 10 + str.charAt(1) - '0') * 60 + (str.charAt(3) - '0') * 10 + str.charAt(4)
                - '0';
    }
}
