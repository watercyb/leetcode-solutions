/*
 * Problem: 327. Count of Range Sum
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/count-of-range-sum/
 * Language: java
 * Date: 2026-04-02
 */

class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        long[] sums = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
        return sep(sums, lower, upper, 0, nums.length);
    }

    public int sep(long[] sum, int lower, int upper, int l, int r) {
        if (l == r)
            return 0;
        int mid = (l + r) >>> 1;
        int res = sep(sum, lower, upper, l, mid) + sep(sum, lower, upper, mid + 1, r);
        long[] arr = new long[r - l + 1];
        int idxArr = 0;
        int rangeL = mid + 1;
        int rangeR = 0;
        int j = mid + 1;
        for (int i = l; i <= mid; i++) {
            while (rangeL <= r && sum[rangeL] - sum[i] < lower) {
                rangeL++;
            }
            if (rangeR < rangeL)
                rangeR = rangeL;
            while (rangeR <= r && sum[rangeR] - sum[i] <= upper) {
                rangeR++;
            }
            res += rangeR - rangeL;
            while (j <= r && sum[i] >= sum[j]) {
                arr[idxArr++] = sum[j++];
            }
            arr[idxArr++] = sum[i];
        }
        for (int i = 0; i < idxArr; i++) {
            sum[i + l] = arr[i];
        }
        return res;
    }
}
