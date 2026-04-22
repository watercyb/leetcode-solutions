/*
 * Problem: 1918. Kth Smallest Subarray Sum
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/kth-smallest-subarray-sum/
 * Language: java
 * Date: 2026-04-22
 */

class Solution {
    public int kthSmallestSubarraySum(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int l = 0;
        int r = sum;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (chk(nums, k, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public boolean chk(int[] nums, int k, int mid) {
        int j = 0;
        int sum = 0;
        for (int i = 0; i < nums.length && k > 0; i++) {
            sum += nums[i];
            while (sum > mid) {
                sum -= nums[j++];
            }
            k -= i - j + 1;
        }
        return k <= 0;
    }
}
