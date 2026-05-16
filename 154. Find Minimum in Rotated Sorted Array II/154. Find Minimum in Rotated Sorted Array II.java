/*
 * Problem: 154. Find Minimum in Rotated Sorted Array II
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/?envType=daily-question&envId=2026-05-16
 * Language: java
 * Date: 2026-05-16
 */

class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (nums[mid] < nums[r]) {
                r = mid;
            } else if (nums[mid] == nums[r]) {
                r--;
            } else {
                l = mid + 1;
                continue;
            }
        }
        return nums[l];

    }
}
