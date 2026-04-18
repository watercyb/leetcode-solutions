/*
 * Problem: 1598. Crawler Log Folder
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/crawler-log-folder/
 * Language: java
 * Date: 2026-04-18
 */

class Solution {
    public int minOperations(String[] logs) {
        int res = 0;
        for (String log : logs) {
            if (log.charAt(1) == '.') {
                if (res > 0)
                    res--;
            } else if (log.charAt(0) != '.') {
                res++;
            }
        }
        return res;
    }
}
