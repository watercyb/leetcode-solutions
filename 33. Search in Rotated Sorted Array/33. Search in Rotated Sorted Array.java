/*
 * Problem: 33. Search in Rotated Sorted Array
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/search-in-rotated-sorted-array/?envType=daily-question&envId=2026-05-22
 * Language: java
 * Date: 2026-05-22
 */

class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        if (nums[l] <= nums[r]) {
            while (l < r) {
                int mid = (l + r) >>> 1;
                if (nums[mid] >= target) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            if (nums[l] == target)
                return l;
            return -1;
        } else if (nums[r] >= target) {
            while (l < r) {
                int mid = (l + r) >>> 1;
                if (nums[mid] == target)
                    return mid;
                if (nums[mid] >= target && nums[mid] <= nums[nums.length - 1]) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            if (nums[l] == target)
                return l;
            return -1;
        } else {
            while (l < r) {
                int mid = (l + r) >>> 1;
                if (nums[mid] == target)
                    return mid;
                if (nums[mid] >= target || nums[mid] < nums[0]) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            if (nums[l] == target)
                return l;
            return -1;
        }

    }
}
