/*
 * Problem: 3635. Earliest Finish Time for Land and Water Rides II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/earliest-finish-time-for-land-and-water-rides-ii/
 * Language: java
 * Date: 2026-05-09
 */

class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < landStartTime.length; i++) {
            min = Math.min(landStartTime[i] + landDuration[i], min);
        }
        int res = Integer.MAX_VALUE;
        int min1 = Integer.MAX_VALUE;
        for (int i = 0; i < waterStartTime.length; i++) {
            min1 = Math.min(waterStartTime[i] + waterDuration[i], min1);
            res = Math.min(Math.max(min, waterStartTime[i]) + waterDuration[i], res);
        }
        for (int i = 0; i < landStartTime.length; i++) {
            res = Math.min(Math.max(min1, landStartTime[i]) + landDuration[i], res);
        }
        return res;
    }
}
