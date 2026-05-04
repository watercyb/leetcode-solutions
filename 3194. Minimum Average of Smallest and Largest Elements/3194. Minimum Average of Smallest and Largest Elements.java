/*
 * Problem: 3194. Minimum Average of Smallest and Largest Elements
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/minimum-average-of-smallest-and-largest-elements/
 * Language: java
 * Date: 2026-05-04
 */

class Solution {
    public double minimumAverage(int[] nums) {
        Arrays.sort(nums);
        double res = Integer.MAX_VALUE;
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            res = Math.min(res, nums[l] + nums[r]);
            l++;
            r--;
        }
        return res / 2;
    }
}
