/*
 * Problem: 4045. Count Robot Groups
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/count-robot-groups/
 * Language: csharp
 * Date: 2026-09-11
 */

public class Solution {
    public int CountGroups(int[] position, int[] speed, int distance) {
        int res=0;
        int min=speed[speed.Length-1];
        for (int i=speed.Length-2;i>=0;i--) {
            if (position[i]+distance>=position[i+1]) continue;
            if (speed[i]<=min) {
                res++;
                min=speed[i];
            }
        }
        return res+1;
    }
}
