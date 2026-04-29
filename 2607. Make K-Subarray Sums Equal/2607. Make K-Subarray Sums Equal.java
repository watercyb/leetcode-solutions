/*
 * Problem: 2607. Make K-Subarray Sums Equal
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/make-k-subarray-sums-equal/
 * Language: java
 * Date: 2026-04-29
 */

class Solution {
    public long makeSubKSumEqual(int[] arr, int k) {
        k = GCD(arr.length, k);
        int[] sort = new int[arr.length / k];
        long res = 0;
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < sort.length; j++) {
                sort[j] = arr[j * k + i];
            }
            Arrays.sort(sort);
            int target = sort[sort.length / 2];
            for (int num : sort) {
                res += Math.abs(target - num);
            }
        }
        return res;
    }

    public int GCD(int a, int b) {
        if (b == 0)
            return a;
        return GCD(b, a % b);
    }
}
