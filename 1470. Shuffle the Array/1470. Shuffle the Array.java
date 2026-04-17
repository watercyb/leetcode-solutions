/*
 * Problem: 1470. Shuffle the Array
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/shuffle-the-array/
 * Language: java
 * Date: 2026-04-17
 */

class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] res=new int[nums.length];
        int l=0;
        int r=n;
        for (int i=0;i<nums.length;i+=2) {
            res[i]=nums[l++];
            res[i+1]=nums[r++];
        }
        return res;
    }
}
