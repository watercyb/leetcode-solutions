/*
 * Problem: 3168. Minimum Number of Chairs in a Waiting Room
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/minimum-number-of-chairs-in-a-waiting-room/
 * Language: java
 * Date: 2026-05-04
 */

class Solution {
    public int minimumChairs(String s) {
        int res = 0;
        int count = 0;
        for (char chr : s.toCharArray()) {
            if (chr == 'E') {
                count++;
                res = Math.max(count, res);
            } else {
                count--;
            }
        }
        return res;
    }
}
