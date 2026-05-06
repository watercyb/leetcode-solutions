/*
 * Problem: 3364. Minimum Positive Sum Subarray
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/minimum-positive-sum-subarray/
 * Language: java
 * Date: 2026-05-06
 */

class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int[] arr = new int[nums.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = nums.get(i);
        }
        int res = Integer.MAX_VALUE;
        for (int i = l; i <= r; i++) {
            res = Math.min(getMin(arr, i), res);
        }
        if (res == Integer.MAX_VALUE)
            return -1;
        return res;
    }

    public int getMin(int[] arr, int i) {
        int sum = 0;
        for (int j = 0; j < i; j++) {
            sum += arr[j];
        }
        int res = Integer.MAX_VALUE;
        if (sum > 0)
            res = sum;
        for (int j = i; j < arr.length; j++) {
            sum += arr[j] - arr[j - i];
            if (sum > 0 && sum < res)
                res = sum;
        }
        return res;
    }
}
