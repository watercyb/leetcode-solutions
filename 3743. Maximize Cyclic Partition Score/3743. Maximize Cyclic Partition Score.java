/*
 * Problem: 3743. Maximize Cyclic Partition Score
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/maximize-cyclic-partition-score/
 * Language: java
 * Date: 2026-05-10
 */

class Solution {
    public long maximumScore(int[] nums, int k) {
        long[][] DP = new long[k + 1][3];
        long[][] DP1=new long[k + 1][3];
        long[][] DP2=new long[k + 1][3];
        for (int i=0;i<DP.length;i++) {
            Arrays.fill(DP[i], Long.MIN_VALUE / 2);
            Arrays.fill(DP1[i], Long.MIN_VALUE / 2);
            Arrays.fill(DP2[i], Long.MIN_VALUE / 2);
        }
        DP[0][1] = 0;
        for (int j=0;j<nums.length;j++) {
            int num=nums[j];
            for (int i = Math.min((j + 1) / 2,DP.length - 2); i >= 0; i--) {
                DP[i + 1][1] = Math.max(Math.max(DP[i + 1][1], DP[i][0] + num), DP[i][2] - num);
                DP[i][0] = Math.max(DP[i ][0], DP[i][1] - num);
                DP[i ][2] = Math.max(DP[i ][2], DP[i][1] + num);
            }
             for (int i =  Math.min((j + 1) / 2,DP.length - 2); i >= 0; i--) {
                DP1[i + 1][1] = Math.max(Math.max(DP1[i + 1][1], DP1[i][0] + num), DP1[i][2] - num);
                DP1[i ][0] = Math.max(DP1[i ][0], DP1[i][1] - num);
                DP1[i][2] = Math.max(DP1[i ][2], DP1[i][1] + num);
            }
            DP1[0][1]=Math.max(DP1[0][1],-num);
             for (int i =  Math.min((j + 1) / 2,DP.length - 2) ;i >= 0; i--) {
                DP2[i + 1][1] = Math.max(Math.max(DP2[i + 1][1], DP2[i][0] + num), DP2[i][2] - num);
                DP2[i ][0] = Math.max(DP2[i ][0], DP2[i][1] - num);
                DP2[i ][2] = Math.max(DP2[i ][2], DP2[i][1] + num);
            }
            DP2[0][1]=Math.max(DP2[0][1],num);
        }
        long res=0;
        for (int i=0;i<DP.length;i++ ) {
            res=Math.max(res,DP[i][1]);
            res=Math.max(res,DP1[i][2]);
            res=Math.max(res,DP2[i][0]);
        }
        return res;
    }
}
