/*
 * Problem: 2149. Rearrange Array Elements by Sign
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/rearrange-array-elements-by-sign/
 * Language: java
 * Date: 2026-04-24
 */

class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] res = new int[nums.length];
        int ip = 0;
        int in = 1;
        for (int i=0;i<nums.length;i++) {
            if (nums[i]>=0) {
                res[ip]=nums[i];
                ip+=2;
            } else {
                res[in]=nums[i];
                in+=2;
            }
        }
        return res;
    }
}
