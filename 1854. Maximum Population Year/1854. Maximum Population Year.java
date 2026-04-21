/*
 * Problem: 1854. Maximum Population Year
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/maximum-population-year/
 * Language: java
 * Date: 2026-04-21
 */

class Solution {
    public int maximumPopulation(int[][] logs) {
        int[] ln=new int[101];
        for (int[] log:logs) {
            ln[log[0]-1950]++;
            ln[log[1]-1950]--;
        }

        int[] max={0,ln[0]};
        int tmp=ln[0];
        for (int i=1;i<101;i++) {
            tmp+=ln[i];
            if (tmp>max[1]) {
                max[1]=tmp;
                max[0]=i;
            }
        }
        
        return max[0]+1950;
        
    }
}
