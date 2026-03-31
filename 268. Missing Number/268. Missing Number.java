/*
 * Problem: 268. Missing Number
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/missing-number/
 * Language: java
 * Date: 2026-03-31
 */

class Solution {
    public int missingNumber(int[] nums) {
        boolean[] seen=new boolean[nums.length+1];
        for (int num:nums) {
            seen[num]=true;
        }
        for (int i=0;i<=nums.length;i++) {
            if (!seen[i]) return i;
        }
        return -1;
    }
}
