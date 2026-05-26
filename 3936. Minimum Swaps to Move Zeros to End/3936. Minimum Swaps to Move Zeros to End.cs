/*
 * Problem: 3936. Minimum Swaps to Move Zeros to End
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/minimum-swaps-to-move-zeros-to-end/
 * Language: csharp
 * Date: 2026-05-26
 */

public class Solution {
    public int MinimumSwaps(int[] nums) {
        int l=0;
        int r=nums.Length-1;
        int res=0;
        while (l<r) {
            if (nums[l]!=0) 
            {
                l++;
            } 
            else if (nums[r]==0) 
            {
                r--;
            }
            else 
            {
                res++;
                l++;
                r--;
            }
        }
        return res;
    }
}
