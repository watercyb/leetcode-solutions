/*
 * Problem: 81. Search in Rotated Sorted Array II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
 * Language: java
 * Date: 2026-03-25
 */

class Solution {
    public boolean search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            if (nums[l] == target || nums[r] == target)
                return true;
            int mid = (l + r) >>> 1;
            if (nums[mid] > target) {
                if (target >= nums[0]) {
                    r = mid;
                } else if (target < nums[0]) {
                    if (nums[mid] > nums[0]) {
                        l = mid + 1;
                    } else if (nums[mid] < nums[0]) {
                        r = mid;
                    } else {
                        l++;
                        r--;
                    }
                }
            } else if (nums[mid] < target) {
                if (target >= nums[0]) {
                    if (nums[mid] > nums[0]) {
                        l = mid + 1;
                    } else if (nums[mid] < nums[0]) {
                        r = mid;
                    } else {
                        l++;
                        r--;
                    }
                } else if (target < nums[0]) {
                    l = mid + 1;
                }
            } else {
                return true;
            }
        }
        return nums[l]==target;
    }
}
