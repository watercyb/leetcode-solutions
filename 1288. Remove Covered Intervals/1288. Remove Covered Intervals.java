/*
 * Problem: 1288. Remove Covered Intervals
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/remove-covered-intervals/?envType=daily-question&envId=2026-07-06
 * Language: java
 * Date: 2026-07-06
 */

class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        int res=intervals.length;
        for (int i=0;i<intervals.length;i++) {
            for (int j=0;j<intervals.length;j++) {
                if (i!=j&&intervals[i][0]>=intervals[j][0]&&intervals[i][1]<=intervals[j][1]) {
                    res--;
                    break;
                } 
            }
        }
        return res;
    }
}
