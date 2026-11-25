/*
 * Problem: 4121. Minimum Cost to Make All Array Elements Equal
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-cost-to-make-all-array-elements-equal/
 * Language: csharp
 * Date: 2026-11-25
 */

public class Solution {
    public long MinCost(int[] nums) {
        int l=0;
        int r=1;
        long res=long.MaxValue;
        while (r<nums.Length-1) {
            if (nums[r]!=nums[l]) {
                l=r;
            }
            res=Math.Min(res, (long)(nums.Length-(r-l+1))*nums[r]);
            r++;
        }
        if (nums[r]==nums[l]) {
            res=Math.Min(res, (long)l*nums[r]);
        }
        return res;
    }
}
