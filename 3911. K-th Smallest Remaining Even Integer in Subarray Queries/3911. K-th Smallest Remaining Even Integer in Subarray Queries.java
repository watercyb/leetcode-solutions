/*
 * Problem: 3911. K-th Smallest Remaining Even Integer in Subarray Queries
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/k-th-smallest-remaining-even-integer-in-subarray-queries/
 * Language: java
 * Date: 2026-04-28
 */

class Solution {
    public int[] kthRemainingInteger(int[] nums, int[][] queries) {
        int count = 0;
        for (int num : nums) {
            if ((num & 1) == 0)
                count++;
        }
        int[] arr = new int[count + 1];
        int[] lefts = new int[nums.length];
        int[] rights = new int[nums.length];
        int idx = 1;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & 1) == 0) {
                arr[idx] = nums[i];
                lefts[i] = rights[i] = idx++;
            } else {
                lefts[i] = idx;
                rights[i] = idx - 1;
            }
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int left = lefts[queries[i][0]];
            int right = rights[queries[i][1]];
            int k = queries[i][2];
            if (left == arr.length || arr[left] > 2 * k) {
                res[i] = 2 * k;
            } else if (arr[right] < 2 * (k + right - left + 1)) {
                res[i] = 2 * (k + right - left + 1);
            } else {
                int l = left;
                int r = right;
                while (l < r) {
                    int mid = (l + r) >>> 1;
                    int num = arr[mid];
                    int c = mid - left + 1;
                    if (num - 2 * c >= 2 * k) {
                        r = mid;
                    } else {
                        l = mid + 1;
                    }
                }
                res[i] = 2 * (l - left + k);
            }
        }
        return res;
    }
}
