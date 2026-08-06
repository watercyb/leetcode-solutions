/*
 * Problem: 4013. Count Subarrays With Even Odd Ratio II
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/count-subarrays-with-even-odd-ratio-ii/
 * Language: java
 * Date: 2026-08-06
 */

class Solution {
    public long countRatioSubarrays(int[] nums, int a, int b) {
        long[][] arr = new long[nums.length][];
        long sum = 0;
        long res = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & 1) == 0) {
                sum += b;
            } else {
                sum -= a;
            }
            arr[i] = new long[] { sum, i };
            if (sum <= 0)
                res++;
        }
        Arrays.sort(arr, (x, y) -> Long.compare(y[0], x[0]));
        BIT = new int[arr.length + 1];
        for (long[] pair : arr) {
            int idx = (int) pair[1];
            res += get(idx);
            insert(idx);
        }
        return res;
    }

    int[] BIT;

    public void insert(int i) {
        i++;
        while (i < BIT.length) {
            BIT[i]++;
            i += i & -i;
        }
    }

    public int get(int i) {
        i++;
        int res = 0;
        while (i > 0) {
            res += BIT[i];
            i -= i & -i;
        }
        return res;
    }
}
