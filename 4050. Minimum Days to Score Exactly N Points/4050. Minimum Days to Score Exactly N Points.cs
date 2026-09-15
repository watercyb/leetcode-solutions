/*
 * Problem: 4050. Minimum Days to Score Exactly N Points
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-days-to-score-exactly-n-points/
 * Language: csharp
 * Date: 2026-09-15
 */

public class Solution {
    public int MinDays(int n) {
        int[] dp=new int[n+1];
        Array.Fill(dp,100000000);
        dp[0]=0;
        for (int i=0;i<n;i++) {
            int sum=1;
            for (int j=1;sum+i<=n;j++) {
                dp[sum+i]=Math.Min(dp[sum+i], dp[i]+j+1);
                sum+=j+1;
            }
        }
        return dp[n]-1;
    }
}
