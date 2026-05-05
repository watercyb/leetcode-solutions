/*
 * Problem: 3231. Minimum Number of Increasing Subsequence to Be Removed
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimum-number-of-increasing-subsequence-to-be-removed/
 * Language: java
 * Date: 2026-05-05
 */

class Solution {
    public int minOperations(int[] nums) {
        int[] arr = new int[nums.length];
        int idx = 0;
        for (int num : nums) {
            if (idx == 0 || num <= arr[idx - 1]) {
                arr[idx++] = num;
            } else {
                int index = binarySearch(arr, idx, num);
                if (index == idx) {
                    arr[idx++] = num;
                } else {
                    arr[index] = num;
                }
            }
        }
        return idx;
    }

    public int binarySearch(int[] arr, int lim, int num) {
        int l = 0;
        int r = lim;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (arr[mid] < num) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
