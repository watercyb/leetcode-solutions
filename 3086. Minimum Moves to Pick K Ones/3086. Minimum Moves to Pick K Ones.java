/*
 * Problem: 3086. Minimum Moves to Pick K Ones
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimum-moves-to-pick-k-ones/
 * Language: java
 * Date: 2026-05-03
 */

class Solution {
    public long minimumMoves(int[] nums, int k, int maxChanges) {
        long res = Long.MAX_VALUE;
        lefts = new long[nums.length];
        arr = new int[nums.length];
        if (k > maxChanges + 3)
            res = getMin(nums, k - maxChanges) + 2 * maxChanges;
        if (k >= 3 && maxChanges >= k - 3)
            res = Math.min(getMin(nums, 3) + 2 * (k - 3), res);
        if (k >= 2 && maxChanges >= k - 2)
            res = Math.min(getMin(nums, 2) + 2 * (k - 2), res);
        if (k >= 1 && maxChanges >= k - 1)
            res = Math.min(getMin(nums, 1) + 2 * (k - 1), res);
        if (maxChanges >= k)
            res = Math.min(2 * k, res);
        return res;
    }

    int[] arr;
    int l = 0;
    int r = 0;
    long[] lefts;

    public long getMin(int[] nums, int n) {
        l = 0;
        r = 0;
        long sum = 0;
        int target = (n + 1) / 2;
        for (int i = 0; i < nums.length; i++) {
            sum += r - l;
            if (nums[i] == 1) {
                arr[r++] = i;
                if (r - l > target)
                    sum -= i - arr[l++];
                if (r - l == target) {
                    lefts[i] = sum;
                } else {
                    lefts[i] = Long.MAX_VALUE / 2;
                }
            } else {
                lefts[i] = Long.MAX_VALUE / 2;
            }
        }
        sum = 0;
        l = 0;
        r = 0;
        target = n / 2 + 1;
        long res = Long.MAX_VALUE / 2;
        for (int i = nums.length - 1; i >= 0; i--) {
            sum += r - l;
            if (nums[i] == 1) {
                arr[r++] = i;
                if (r - l > target)
                    sum -= arr[l++] - i;
                if (r - l == target)
                    res = Math.min(lefts[i] + sum, res);
            }
        }
        return res;
    }
}
