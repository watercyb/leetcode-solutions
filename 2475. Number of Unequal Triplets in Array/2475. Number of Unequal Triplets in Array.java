/*
 * Problem: 2475. Number of Unequal Triplets in Array
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/number-of-unequal-triplets-in-array/
 * Language: java
 * Date: 2026-04-27
 */

class Solution {
    public int unequalTriplets(int[] nums) {
        int[] counts = new int[1001];
        int pairs = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res += pairs - counts[nums[i]] * (i - counts[nums[i]]);
            pairs += i - counts[nums[i]];
            counts[nums[i]]++;
        }
        return res;
    }
}
