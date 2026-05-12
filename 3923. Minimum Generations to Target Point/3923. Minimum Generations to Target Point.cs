/*
 * Problem: 3923. Minimum Generations to Target Point
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-generations-to-target-point/
 * Language: csharp
 * Date: 2026-05-12
 */

public class Solution {
    public int MinGenerations(int[][] points, int[] target) {
        int max=0;
        foreach (int[] point in points) {
            foreach (int num in point) {
                max=Math.Max(max, num);
            }
        }
        if (target[0]>max||target[1]>max||target[2]>max) return -1;
        bool[,,] dp=new bool[max+1,max+1,max+1];
        foreach (int[] point in points) {
            dp[point[0],point[1],point[2]]=true;
        }
        bool changed=true;
        int stp=0;
        while (changed) {
            changed=false;
            if (dp[target[0],target[1],target[2]]) return stp;
            bool[,,] dpNext=new bool[max+1,max+1,max+1];
            for (int i=0;i<=max;i++) {
                for (int j=0;j<=max;j++) {
                    for (int k=0;k<=max;k++) {
                        if (!dp[i,j,k]) continue;
                        dpNext[i,j,k]=true;
                        for (int i1=0;i1<=max;i1++) {
                            for (int j1=0;j1<=max;j1++) {
                                for (int k1=0;k1<=max;k1++) {
                                    if (!dp[i1,j1,k1]) continue;
                                    int iNext=(i+i1)/2;
                                    int jNext=(j+j1)/2;
                                    int kNext=(k+k1)/2;
                                    if (!dp[iNext,jNext,kNext]) changed=true;
                                    dpNext[iNext,jNext,kNext]=true;
                                }
                            }
                        }
                    }
                }
            }
            dp=dpNext;
            stp++;
        }
        return -1;
    }
}
