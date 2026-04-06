/*
 * Problem: 657. Robot Return to Origin
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/robot-return-to-origin/
 * Language: java
 * Date: 2026-04-06
 */

class Solution {
    public boolean judgeCircle(String moves) {
        int[] counts = new int['U' + 1];
        for (char chr : moves.toCharArray()) {
            counts[chr]++;
        }
        return counts['U'] == counts['D'] && counts['R'] == counts['L'];
    }
}
