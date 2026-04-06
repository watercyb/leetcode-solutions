/*
 * Problem: 645. Set Mismatch
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/set-mismatch/
 * Language: java
 * Date: 2026-04-06
 */

class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] counts=new int[nums.length+1];
        int res=0;
        for (int num:nums) {
            if (counts[num]==0) {
                counts[num]++;
            } else {
                res=num;
            }
        }
        for (int i=1;i<=nums.length;i++) {
            if (counts[i]==0) return new int[] {res,i};
        }
        return new int[] {res,-1};
    }
}
