/*
 * Problem: 1578. Minimum Time to Make Rope Colorful
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-time-to-make-rope-colorful/
 * Language: java
 * Date: 2026-04-18
 */

class Solution {
    public int minCost(String colors, int[] neededTime) {
        char[] coler=colors.toCharArray();
        int[] max={0,0};
        for (int i=1;i<coler.length;i++) {
            while (coler[i-1]==coler[i]) {
                max[0]+=neededTime[i-1];
                max[1]=Math.max(max[1], neededTime[i-1]);
                if (i==coler.length-1) {
                    max[0]+=neededTime[i];
                    max[1]=Math.max(max[1], neededTime[i]);
                    max[0]-=max[1];
                    return max[0];
                }
                i++;
            }
            if (max[1]>0){
                max[0]+=neededTime[i-1];
                max[1]=Math.max(max[1], neededTime[i-1]);
                max[0]-=max[1];
                max[1]=0;
            }
            
        }
        return max[0];

    }
}
