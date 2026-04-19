/*
 * Problem: 1619. Mean of Array After Removing Some Elements
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/mean-of-array-after-removing-some-elements/
 * Language: java
 * Date: 2026-04-19
 */

class Solution {
    public double trimMean(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length / 20;
        double sum = 0;
        for (int i = n; i < arr.length - n; i++) {
            sum += arr[i];
        }
        return sum / (arr.length - 2 * n);
    }
}
