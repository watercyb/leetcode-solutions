/*
 * Problem: 3867. Sum of GCD of Formed Pairs
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/sum-of-gcd-of-formed-pairs/?envType=daily-question&envId=2026-07-16
 * Language: csharp
 * Date: 2026-07-16
 */

public class Solution {
    public long GcdSum(int[] nums) {
        int max=0;
        for (int i=0;i<nums.Length;i++) {
            max=Math.Max(max,nums[i]);
            nums[i]=GCD(max, nums[i]);
        }
        int l=0;
        int r=nums.Length-1;
        long res=0;
        Array.Sort(nums);
        while (l<r) {
            res+=GCD(nums[l],nums[r]);
            l++;
            r--;
        }
        return res;
    }

    public int GCD(int a, int b) {
        if (b==0) return a;
        return GCD(b,a%b);
    }
}
