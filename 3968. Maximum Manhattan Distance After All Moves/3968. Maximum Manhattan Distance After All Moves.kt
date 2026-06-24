/*
 * Problem: 3968. Maximum Manhattan Distance After All Moves
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-manhattan-distance-after-all-moves/
 * Language: kotlin
 * Date: 2026-06-24
 */

class Solution {
    fun maxDistance(moves: String): Int {
        var x=0
        var y=0
        var count=0
        for (chr in moves) {
            if (chr=='U') {
                x++;
            } else if (chr=='D') {
                x--;
            } else if (chr=='L') {
                y++;
            } else if (chr=='R') {
                y--;
            } else {
                count++
            }
        }
        return abs(x)+abs(y)+count
    }
}
