/*
 * Problem: 1574. Shortest Subarray to be Removed to Make Array Sorted
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/shortest-subarray-to-be-removed-to-make-array-sorted/
 * Language: java
 * Date: 2026-04-18
 */

class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int idx = 0;
        int prv = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= prv) {
                idx++;
                prv = arr[i];
            } else {
                break;
            }
        }
        if (idx == arr.length)
            return 0;
        int res = arr.length - idx;
        idx--;
        prv = Integer.MAX_VALUE;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] > prv)
                break;
            while (idx >= 0 && arr[idx] > arr[i]) {
                idx--;
            }
            res = Math.min(i - idx - 1, res);
            prv = arr[i];
        }
        return res;
    }
}
