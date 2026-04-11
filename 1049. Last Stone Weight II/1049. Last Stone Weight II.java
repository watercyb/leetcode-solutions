/*
 * Problem: 1049. Last Stone Weight II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/last-stone-weight-ii/
 * Language: java
 * Date: 2026-04-11
 */

class Solution {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        boolean[] DP = new boolean[sum + 1];
        DP[0] = true;
        for (int i = 0; i < stones.length ; i++) {
            boolean[] DPNext = new boolean[sum + 1];
            for (int j = 0; j <= sum; j++) {
                if (DP[j]) {
                    DPNext[j] = true;
                    DPNext[j + stones[i]] = true;
                }
            }
            DP=DPNext;
        }
        int min=sum;
        for (int i=0;i<=sum;i++) {
            if (DP[i]) {
                min=Math.min(Math.abs(sum-2*i),min);
            }
        }
        return min;
    }
}
