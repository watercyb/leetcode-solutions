/*
 * Problem: 3101. Count Alternating Subarrays
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/count-alternating-subarrays/
 * Language: java
 * Date: 2026-05-04
 */

class Solution {
    public long countAlternatingSubarrays(int[] nums) {
        long res = 0;
        int prv = nums[0];
        int count = 0;
        for (int num : nums) {
            if (num == prv) {
                res += (long) (count + 1) * count / 2;
                count = 1;
            } else {
                count++;
            }
            prv = num;
        }
        res += (long) (count + 1) * count / 2;
        return res;
    }
}
