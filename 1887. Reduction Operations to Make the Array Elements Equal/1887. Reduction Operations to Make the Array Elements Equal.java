/*
 * Problem: 1887. Reduction Operations to Make the Array Elements Equal
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/reduction-operations-to-make-the-array-elements-equal/
 * Language: java
 * Date: 2026-04-21
 */

class Solution {
    public int reductionOperations(int[] nums) {
        int[] counts = new int[50001];
        for (int i = 0; i < nums.length; i++) {
            counts[nums[i]]++;
        }
        int count=0;
        int res=0;
        for (int i=counts.length-1;i>=0;i--) {
            if (counts[i]==0) continue;
            res+=count;
            count+=counts[i];
        }
        return res;
    }
}
