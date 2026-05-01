/*
 * Problem: 2870. Minimum Number of Operations to Make Array Empty
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-number-of-operations-to-make-array-empty/
 * Language: java
 * Date: 2026-05-01
 */

class Solution {
    public int minOperations(int[] nums) {
        Arrays.sort(nums);
        int i=0;
        int res=0;
        while (i<nums.length) {
            int tmp=nums[i];
            int count=1;
            while (++i<nums.length&&nums[i]==tmp) {
                count++;
            }
            if (count==1) return -1;
            res+=count/3;
            if (count%3>0) res++;
        }
        
        return res;

    }
}
