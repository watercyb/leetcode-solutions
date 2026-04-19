/*
 * Problem: 1674. Minimum Moves to Make Array Complementary
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-moves-to-make-array-complementary/
 * Language: java
 * Date: 2026-04-19
 */

class Solution {
    public int minMoves(int[] nums, int limit) {
        int n=nums.length-1;
        int l=limit*2;
        int[] arr=new int[l+2];
        for (int i=0;i<nums.length/2;i++) {
            int sum=nums[i]+nums[n-i];
            int min=Math.min(nums[i],nums[n-i])+1;
            int max=sum-min+limit+2;
            arr[min]--;
            arr[max]++;
            arr[sum]--;
            arr[sum+1]++;
        }

        int res=nums.length;
        int tmp=0;
        for (int i=2;i<=l;i++) {
            tmp+=arr[i];
            if (tmp<res) res=tmp;
        }
        return nums.length+res;
    }
}
