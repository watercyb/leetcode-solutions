/*
 * Problem: 1629. Slowest Key
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/slowest-key/
 * Language: java
 * Date: 2026-04-19
 */

class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        char res = keysPressed.charAt(0);
        int maxTime = releaseTimes[0];
        for (int i = 1; i < releaseTimes.length; i++) {
            int currentTime = releaseTimes[i] - releaseTimes[i - 1];
            if (currentTime > maxTime || (currentTime == maxTime && keysPressed.charAt(i) > res)) {
                maxTime = currentTime;
                res = keysPressed.charAt(i);
            }
        }
        return res;
    }
}
