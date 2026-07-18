/*
 * Problem: 3994. Minimum Adjacent Swaps to Partition Array
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-adjacent-swaps-to-partition-array/
 * Language: csharp
 * Date: 2026-07-18
 */

public class Solution {
    public int MinAdjacentSwaps(int[] nums, int a, int b) {
        long res=0;
        int count=0;
        for (int i=nums.Length-1;i>=0;i--) {
            if (nums[i]<=b) {
                count++;
            } else {
                res+=count;
            }
        }
        count=0;
        for (int i=nums.Length-1;i>=0;i--) {
            if (nums[i]<a) {
                count++;
            } else if (nums[i]<=b) {
                res+=count;
            }
        }
        return (int)(res%1_000_000_007);
    }
}
