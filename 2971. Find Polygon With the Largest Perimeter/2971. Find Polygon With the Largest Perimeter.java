/*
 * Problem: 2971. Find Polygon With the Largest Perimeter
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-polygon-with-the-largest-perimeter/
 * Language: java
 * Date: 2026-05-02
 */

class Solution {
    public long largestPerimeter(int[] nums) {
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        boolean[] toLarge = new boolean[nums.length];
        int count=nums.length;
        int prvCount=0;
        while (count!=prvCount) {
            prvCount=count;
            for (int i = 0; i < nums.length; i++) {
                if (toLarge[i])
                    continue;
                if (sum <= nums[i] * 2) {
                    sum -= nums[i];
                    toLarge[i] = true;
                    count--;
                }
            }
        }
        if (count>=3) return sum;
        return -1;
    }
}
