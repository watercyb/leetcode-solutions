/*
 * Problem: 3894. Traffic Signal Color
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/traffic-signal-color/
 * Language: kotlin
 * Date: 2026-04-14
 */

class Solution {
    fun trafficSignal(timer: Int): String {
        if (timer==0) return "Green";
        if (timer==30) return "Orange";
        if (timer>30&&timer<=90) return "Red";
        return "Invalid";
    }
}
