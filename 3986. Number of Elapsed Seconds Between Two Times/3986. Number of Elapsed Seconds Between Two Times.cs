/*
 * Problem: 3986. Number of Elapsed Seconds Between Two Times
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/number-of-elapsed-seconds-between-two-times/
 * Language: csharp
 * Date: 2026-07-17
 */

public class Solution {
    public int SecondsBetweenTimes(string startTime, string endTime) {
        return getSecond(endTime)-getSecond(startTime);
    }

    public int getSecond(string t) {
        return (t[0]-'0')*36000+(t[1]-'0')*3600+(t[3]-'0')*600+(t[4]-'0')*60+(t[6]-'0')*10+(t[7]-'0');
    }
}
