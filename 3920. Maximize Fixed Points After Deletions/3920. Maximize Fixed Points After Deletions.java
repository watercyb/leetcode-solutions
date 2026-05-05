/*
 * Problem: 3920. Maximize Fixed Points After Deletions
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/maximize-fixed-points-after-deletions/
 * Language: java
 * Date: 2026-05-05
 */

class Solution {
    public int maxFixedPoints(int[] nums) {
        //numA<numB && a-numA<=b-numB -> a<b
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= i)
                count++;
        }
        long[] arr = new long[count];
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= i)
                arr[idx++] = ((long) (i - nums[i]) << 32) + nums[i];
        }
        Arrays.sort(arr);
        int[] DP = new int[count];
        idx = 0;
        for (long num : arr) {
            int n = (int) num;
            int l = 0;
            int r = idx;
            while (l < r) {
                int mid = (l + r) >>> 1;
                if (DP[mid] >= n) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            if (l == idx)
                idx++;
            DP[l] = n;
        }
        return idx;
    }
}
