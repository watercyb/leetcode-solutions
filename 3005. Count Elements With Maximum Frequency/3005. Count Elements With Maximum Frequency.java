/*
 * Problem: 3005. Count Elements With Maximum Frequency
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/count-elements-with-maximum-frequency/
 * Language: java
 * Date: 2026-05-03
 */

class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] counts = new int[101];
        int max = 0;
        for (int num : nums) {
            counts[num]++;
            if (counts[num] > max)
                max = counts[num];
        }
        int res = 0;
        for (int i = 0; i < 101; i++) {
            if (counts[i] == max)
                res++;
        }
        return res * max;
    }
}
