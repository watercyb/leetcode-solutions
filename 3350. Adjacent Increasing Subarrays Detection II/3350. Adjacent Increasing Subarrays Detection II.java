/*
 * Problem: 3350. Adjacent Increasing Subarrays Detection II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/adjacent-increasing-subarrays-detection-ii/
 * Language: java
 * Date: 2026-05-06
 */

class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int[] arr = new int[nums.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = nums.get(i);
        }
        int j = 1;
        while (j < arr.length && arr[j] > arr[j - 1]) {
            j++;
        }
        int res = j / 2;
        int i = 0;
        while (j < arr.length) {
            int k = j + 1;
            while (k < arr.length && arr[k] > arr[k - 1]) {
                k++;
            }
            res = Math.max(Math.max(res, (k - j) / 2), Math.min(j - i, k - j));
            i = j;
            j = k;
        }
        return res;
    }
}
