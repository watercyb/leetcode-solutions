/*
 * Problem: 1512. Number of Good Pairs
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/number-of-good-pairs/
 * Language: java
 * Date: 2026-04-18
 */

class Solution {
    public int numIdenticalPairs(int[] nums) {
        int[] counts=new int[101];
        for (int num:nums) {
            counts[num]++;
        }
        int res=0;
        for (int i=0;i<101;i++) {
            res+=counts[i]*(counts[i]-1)/2;
        }
        return res;
    }
}
