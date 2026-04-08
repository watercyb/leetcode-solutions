/*
 * Problem: 743. Network Delay Time
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/network-delay-time/
 * Language: java
 * Date: 2026-04-08
 */

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] delayTime=new int[n+1];
                delayTime[0]=1;
        delayTime[k]=1;
        boolean updated=true;

        while (updated) {
            updated=false;
            for (int[] time:times) {
                if (delayTime[time[0]]>0&&(delayTime[time[1]]==0||delayTime[time[1]]>delayTime[time[0]]+time[2])) {
                        delayTime[time[1]]=delayTime[time[0]]+time[2];
                        updated=true;
                    
                }
            }
        }

        int max=0;
        for (int time:delayTime) {
            if (time>max) max=time;
            if (time==0) return -1;
        }
        return max-1; 
    }
}
