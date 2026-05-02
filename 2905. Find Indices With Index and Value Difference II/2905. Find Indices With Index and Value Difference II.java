/*
 * Problem: 2905. Find Indices With Index and Value Difference II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-indices-with-index-and-value-difference-ii/
 * Language: java
 * Date: 2026-05-02
 */

class Solution {
    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        int max = 0;
        int min = 0;
        for (int i = indexDifference; i < nums.length; i++) {
            if (nums[i - indexDifference] > nums[max])
                max = i - indexDifference;
            if (nums[i - indexDifference] < nums[min])
                min = i - indexDifference;
            if (nums[max] - nums[i] >= valueDifference)
                return new int[] { i, max };
            if (nums[i] - nums[min] >= valueDifference)
                return new int[] { i, min };
        }
        return new int[] { -1, -1 };
    }
}
