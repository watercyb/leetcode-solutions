/*
 * Problem: 2551. Put Marbles in Bags
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/put-marbles-in-bags/
 * Language: java
 * Date: 2026-04-28
 */

class Solution {
    public long putMarbles(int[] weights, int k) {
        int[] arr = new int[weights.length - 1];
        for (int i = 0; i < weights.length - 1; i++) {
            arr[i] = weights[i] + weights[i + 1];
        }
        Arrays.sort(arr);
        long res = 0;
        k--;
        if (k > arr.length - k)
            k = arr.length - k;
        for (int i = 0; i < k; i++) {
            res += arr[arr.length - 1 - i] - arr[i];
        }
        return res;
    }
}
