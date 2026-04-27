/*
 * Problem: 2422. Merge Operations to Turn Array Into a Palindrome
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/merge-operations-to-turn-array-into-a-palindrome/
 * Language: java
 * Date: 2026-04-27
 */

class Solution {
    public int minimumOperations(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int sumL = nums[l];
        int sumR = nums[r];
        int res = 0;
        while (l < r) {
            if (sumL < sumR) {
                res++;
                l++;
                sumL += nums[l];
            } else if (sumL > sumR) {
                res++;
                r--;
                sumR += nums[r];
            } else {
                l++;
                r--;
                sumL += nums[l];
                sumR += nums[r];
            }
        }
        return res;
    }
}
