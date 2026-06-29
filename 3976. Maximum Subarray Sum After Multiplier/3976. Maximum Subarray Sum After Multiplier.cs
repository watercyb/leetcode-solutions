/*
 * Problem: 3976. Maximum Subarray Sum After Multiplier
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-subarray-sum-after-multiplier/
 * Language: csharp
 * Date: 2026-06-29
 */

public class Solution {
    public long MaxSubarraySum(int[] nums, int k) {
        long[] proLefts=new long[nums.Length];
        long[] divLefts=new long[nums.Length];
        long sum=0;
        long pro=0;
        long div=0;
        int max=int.MinValue;
        for (int i=0;i<nums.Length;i++) {
            pro=Math.Max(Math.Max(pro, sum)+(long)nums[i]*k,0);
            div=Math.Max(Math.Max(div, sum)+(long)nums[i]/k,0);
            sum=Math.Max(sum+(long)nums[i],0);
            proLefts[i]=pro;
            divLefts[i]=div;
            max=Math.Max(max, nums[i]);
        }
        if (max<=0) return max/k;
        long res=long.MinValue;
        sum=0;
        pro=0;
        div=0;
        for (int i=nums.Length-1;i>=0;i--) {
            res=Math.Max(res, Math.Max(pro+proLefts[i], div+divLefts[i]));
            pro=Math.Max(Math.Max(pro, sum)+(long)nums[i]*k,0);
            div=Math.Max(Math.Max(div, sum)+(long)nums[i]/k,0);
            sum=Math.Max(sum+(long)nums[i],0);
        }
        return res;
    }
}
