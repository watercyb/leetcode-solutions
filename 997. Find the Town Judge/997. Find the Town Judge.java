/*
 * Problem: 997. Find the Town Judge
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/find-the-town-judge/
 * Language: java
 * Date: 2026-04-10
 */

class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] trusts=new int[n+1];
        int[] trusteds=new int[n+1];
        for (int[] arr:trust) {
            trusts[arr[0]]++;
            trusteds[arr[1]]++;
        }
        int res=-1;
        for (int i=1;i<=n;i++) {
            if (trusts[i]==0&&trusteds[i]==n-1) {
                if (res!=-1) return -1;
                res=i;
            }
        }
        return res;
    }
}
