/*
 * Problem: 2862. Maximum Element-Sum of a Complete Subset of Indices
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/maximum-element-sum-of-a-complete-subset-of-indices/
 * Language: java
 * Date: 2026-05-01
 */

class Solution {
    public long maximumSum(List<Integer> nums) {
        int n=nums.size();
        long res = 0;
        for (int i = 1; i <=n ; i++) {
            long sum = 0;
            for (long j = 1; j * j * i <=n; j++) {
                sum += nums.get((int) (j * j * i)-1);
            }
            res=Math.max(res,sum);
        }
        return res;
    }
}
