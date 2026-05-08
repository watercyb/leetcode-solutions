/*
 * Problem: 3555. Smallest Subarray to Sort in Every Sliding Window
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/smallest-subarray-to-sort-in-every-sliding-window/
 * Language: java
 * Date: 2026-05-08
 */

class Solution {
    public int[] minSubarraySort(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        if (k == 1)
            return res;
        Deque<int[]> Dq = new ArrayDeque<>();
        int[] arr = new int[nums.length];
        int l = 0;
        int r = 0;
        for (int i = 0; i < k; i++) {
            while (l < r && nums[arr[r - 1]] <= nums[i]) {
                r--;
            }
            if (l < r)
                Dq.offerFirst(new int[] { i, arr[r - 1] });
            arr[r++] = i;
        }
        if (!Dq.isEmpty())
            res[0] = Dq.peekFirst()[0];
        for (int i = k; i < nums.length; i++) {
            while (arr[l] <= i - k) {
                l++;
            }
            while (l < r && nums[arr[r - 1]] <= nums[i]) {
                r--;
            }
            while (!Dq.isEmpty() && Dq.peekFirst()[1] <= i - k) {
                Dq.pollFirst();
            }
            if (l < r)
                Dq.offerFirst(new int[] { i, arr[r - 1] });
            if (!Dq.isEmpty())
                res[i - k + 1] = Dq.peekFirst()[0];
            arr[r++] = i;
        }

        Dq.clear();
        l = 0;
        r = 0;
        for (int i = nums.length - 1; i >= nums.length - k; i--) {
            while (l < r && nums[arr[r - 1]] >= nums[i]) {
                r--;
            }
            if (l < r)
                Dq.offerFirst(new int[] { i, arr[r - 1] });
            arr[r++] = i;
        }
        if (res[res.length - 1] <= res.length - 1) {
            res[res.length - 1] = 0;
        } else {
            res[res.length - 1] -= Dq.peekFirst()[0] - 1;
        }
        for (int i = nums.length - k - 1; i >= 0; i--) {
            while (arr[l] >= i + k) {
                l++;
            }
            while (l < r && nums[arr[r - 1]] >= nums[i]) {
                r--;
            }

            while (!Dq.isEmpty() && Dq.peekFirst()[1] >= i + k) {
                Dq.pollFirst();
            }
            if (l < r)
                Dq.offerFirst(new int[] { i, arr[r - 1] });

            if (res[i] <= i) {
                res[i] = 0;
            } else {
                res[i] -= Dq.peekFirst()[0] - 1;
            }
            arr[r++] = i;
        }
        return res;
    }
}
