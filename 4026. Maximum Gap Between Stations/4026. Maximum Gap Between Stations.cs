/*
 * Problem: 4026. Maximum Gap Between Stations
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-gap-between-stations/
 * Language: csharp
 * Date: 2026-08-18
 */

public class Solution {
    public int MaximumGap(string skill, string station) {
        int[] lefts=new int[skill.Length];
        int idx=0;
        for (int i=0;i<station.Length&&idx<skill.Length;i++) {
            if (station[i]==skill[idx]) {
                lefts[idx]=i;
                idx++;
            }
        }
        int res=0;
        idx=skill.Length-1;
        for (int i=station.Length-1;i>=0&&idx>0;i--) {
            if (station[i]==skill[idx]) {
                res=Math.Max(res,i-lefts[idx-1]);
                idx--;
            }
        }
        return res;
    }
}
