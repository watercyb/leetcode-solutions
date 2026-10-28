/*
 * Problem: 4093. Maximize Sum After At Most K Digit Rearrangements
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximize-sum-after-at-most-k-digit-rearrangements/
 * Language: java
 * Date: 2026-10-28
 */

class Solution {
    public long maximizeSum(int[] nums, int k) {
        long[] arr = new long[nums.length];
        long res = 0;
        for (int i = 0; i < nums.length; i++) {
            arr[i] = rearrange(nums[i]);
            res += nums[i];
        }
        Arrays.sort(arr);
        for (int i = arr.length - 1; i >= arr.length - k; i--) {
            res += arr[i];
        }
        return res;
    }

    public long rearrange(int num) {
        int n = num;
        int[] counts = new int[10];
        while (n > 0) {
            counts[n % 10]++;
            n /= 10;
        }
        long number = 0;
        for (int i = 9; i >= 0; i--) {
            for (int j = 0; j < counts[i]; j++) {
                number = number * 10 + i;
            }
        }
        return number - num;
    }
}
