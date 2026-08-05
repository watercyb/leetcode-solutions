/*
 * Problem: 4010. Maximize Pair Strength Using GCD
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/maximize-pair-strength-using-gcd/
 * Language: csharp
 * Date: 2026-08-05
 */

public class Solution {
    public long MaxPairStrength(int[] nums) {
        Array.Sort(nums);
        long res=0;
        for (int i=nums.Length-2;i>=0;i--) {
            if ((long)nums[i]*nums[nums.Length-1]<=res) break;
            for (int j=nums.Length-1;j>=1;j--) {
                long pro=(long)nums[i]*nums[j];
                if (pro<=res) break;
                res=Math.Max(res, pro/(long)Math.Pow(GCD(nums[i],nums[j]),2));
            } 
        }
        return res;
    }

    public long GCD(int a, int b) {
        if (b==0) return a;
        return GCD(b, a%b);
    }
}
