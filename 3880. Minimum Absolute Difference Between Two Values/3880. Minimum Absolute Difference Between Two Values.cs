/*
 * Problem: 3880. Minimum Absolute Difference Between Two Values
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/minimum-absolute-difference-between-two-values/
 * Language: csharp
 * Date: 2026-03-31
 */

public class Solution {
    public int MinAbsoluteDifference(int[] nums) {
        int prv=0;
        int prvIdx=-1;
        int res=nums.Length;
        for (int i=0;i<nums.Length;i++) {
            if (nums[i]==1) {
                if (prv==2){
                    res=Math.Min(res, i-prvIdx);
                }
                prv=1;
                prvIdx=i;
            } else if (nums[i]==2) {
                if (prv==1){
                    res=Math.Min(res, i-prvIdx);
                }
                prv=2;
                prvIdx=i;
            }
        }
        if (res==nums.Length) return -1;
        return res;
    }
}
