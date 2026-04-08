/*
 * Problem: 786. K-th Smallest Prime Fraction
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/k-th-smallest-prime-fraction/
 * Language: java
 * Date: 2026-04-08
 */

class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int max = arr[arr.length - 1] * arr[arr.length - 2];
        int l = 0;
        int r = max;
        int[] res = { -1, -1 };
        while (l < r) {
            int mid = (l + r) >>> 1;
            int[] tmp = chk(arr, k, mid, max);
            if (tmp[0] != 0) {
                r = mid;
                res = tmp;
            } else {
                l = mid + 1;
            }
        }
        return res;
    }

    public int[] chk(int[] arr, int k, int mid, int max) {
        int[] res = { 0, 1 };
        int j = arr.length - 2;
        for (int i = arr.length - 1; i > 0; i--) {
            long tmp = (long) mid * arr[i];
            while (j >= 0 && (long) arr[j] * max > tmp) {
                j--;
            }
            if (j >= 0) {
                if (arr[j] * res[1] > res[0] * arr[i]) {
                    res[0] = arr[j];
                    res[1] = arr[i];
                }
            } else {
                break;
            }
            k -= j + 1;
        }
        if (k <= 0)
            return res;
        return new int[] { 0, 0 };
    }
}
