/*
 * Problem: 4088. Difference Between Peaks and Valleys
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/difference-between-peaks-and-valleys/
 * Language: csharp
 * Date: 2026-10-25
 */

public class Solution {
    public int PeakValleyDifference(int[] nums) {
        int res=0;
        for (int i=1;i<nums.Length-1;i++) {
            res+=check(nums, i);
        }
        return res;
    }

    public int check(int[] nums, int i) {
        if (nums[i-1]>nums[i]&&nums[i+1]>nums[i])
            return -nums[i];
        if (nums[i-1]<nums[i]&&nums[i+1]<nums[i])
            return nums[i];
        return 0;
    }
}
