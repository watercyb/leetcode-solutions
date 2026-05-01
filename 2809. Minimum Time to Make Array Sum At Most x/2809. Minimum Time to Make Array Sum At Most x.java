/*
 * Problem: 2809. Minimum Time to Make Array Sum At Most x
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimum-time-to-make-array-sum-at-most-x/
 * Language: java
 * Date: 2026-05-01
 */

class Solution {
    public int minimumTime(List<Integer> nums1, List<Integer> nums2, int x) {
        int[][] arr = new int[nums1.size()][];
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new int[] { nums1.get(i), nums2.get(i) };
            sum1 += nums1.get(i);
            sum2 += nums2.get(i);
        }
        if (sum1 <= x)
            return 0;
        Arrays.sort(arr, (a, b) -> a[1] - b[1]);
        int res = arr.length + 1;
        int[] DP = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            int lim = Math.min(i + 1, res);
            int sum = arr[i][0] + arr[i][1] * lim;
            for (int j = lim; j > 0; j--) {
                DP[j] = Math.max(DP[j], DP[j - 1] + sum);
                if (sum1 + sum2 * j - DP[j] <= x)
                    res = j;
                sum -= arr[i][1];
            }
        }
        if (res == arr.length + 1)
            return -1;
        return res;
    }
}
