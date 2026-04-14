/*
 * Problem: 1191. K-Concatenation Maximum Sum
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/k-concatenation-maximum-sum/
 * Language: java
 * Date: 2026-04-14
 */

class Solution {
    public int kConcatenationMaxSum(int[] arr, int k) {
        int mod = 1_000_000_007;
        if (k == 1) {
            long sum = 0;
            long res = 0;
            for (int num : arr) {
                sum += num;
                if (sum < 0)
                    sum = 0;
                res = Math.max(res, sum);
            }
            return (int) (res % mod);
        }
        long total = 0;
        for (int num : arr) {
            total += num;
        }
        if (total > 0) {
            long sum = 0;
            long left = 0;
            for (int i = arr.length - 1; i >= 0; i--) {
                sum += arr[i];
                left = Math.max(left, sum);
            }
            sum = 0;
            long right = 0;
            for (int i = 0; i < arr.length; i++) {
                sum += arr[i];
                right = Math.max(right, sum);
            }
            return (int) ((left + right + (k - 2) * total) % mod);
        } else {
            long sum = 0;
            long res = 0;
            for (int i = 0; i < arr.length * 2; i++) {
                sum += arr[i % arr.length];
                if (sum < 0)
                    sum = 0;
                res = Math.max(res, sum);
            }
            return (int) (res % mod);
        }
    }
}
