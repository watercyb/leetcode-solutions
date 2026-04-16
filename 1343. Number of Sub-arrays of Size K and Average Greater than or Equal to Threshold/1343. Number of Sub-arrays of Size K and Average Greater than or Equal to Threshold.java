/*
 * Problem: 1343. Number of Sub-arrays of Size K and Average Greater than or Equal to Threshold
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/number-of-sub-arrays-of-size-k-and-average-greater-than-or-equal-to-threshold/
 * Language: java
 * Date: 2026-04-16
 */

class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        threshold *= k;
        int res = 0;
        if (sum >= threshold)
            res++;
        for (int i = k; i < arr.length; i++) {
            sum += arr[i] - arr[i - k];
            if (sum >= threshold)
                res++;
        }
        return res;
    }
}
