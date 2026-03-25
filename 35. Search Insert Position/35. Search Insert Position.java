/*
 * Problem: 35. Search Insert Position
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/search-insert-position/
 * Language: java
 * Date: 2026-03-25
 */

class Solution {
    public int searchInsert(int[] nums, int target) {
        int l=0;
        int r=nums.length;
        while (l<r) {
            int mid=(l+r)>>>1;
            if (nums[mid]>=target) {
                r=mid;
            } else {
                l=mid+1;
            }
        }
        return l;
    }
}
