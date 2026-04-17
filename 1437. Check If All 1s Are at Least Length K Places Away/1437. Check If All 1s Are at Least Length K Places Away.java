/*
 * Problem: 1437. Check If All 1's Are at Least Length K Places Away
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/check-if-all-1s-are-at-least-length-k-places-away/
 * Language: java
 * Date: 2026-04-17
 */

class Solution {

    public boolean kLengthApart(int[] nums, int k) {
        int prv = -k - 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (i - prv <= k) {
                    return false;
                } else {
                    prv=i;
                }
            }
        }
        return true;
    }
}

