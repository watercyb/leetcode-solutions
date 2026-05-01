/*
 * Problem: 2833. Furthest Point From Origin
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/furthest-point-from-origin/
 * Language: java
 * Date: 2026-05-01
 */

class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int a = 0;
        int b = 0;
        for (char chr : moves.toCharArray()) {
            if (chr == 'R') {
                a++;
            } else if (chr == 'L') {
                a--;
            } else {
                b++;
            }
        }
        return Math.abs(a) + b;
    }
}
