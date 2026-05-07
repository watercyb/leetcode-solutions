/*
 * Problem: 3471. Find the Largest Almost Missing Integer
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/find-the-largest-almost-missing-integer/
 * Language: java
 * Date: 2026-05-07
 */

class Solution {
    public int largestInteger(int[] nums, int k) {
        int[] counts = new int[51];
        for (int i = 0; i < nums.length; i++) {
            counts[nums[i]]++;
        }
        if (k == 1) {
            for (int i = counts.length - 1; i >= 0; i--) {
                if (counts[i] == 1)
                    return i;
            }
            return -1;
        } else if (k == nums.length) {
            int res = -1;
            for (int i = 0; i < counts.length; i++) {
                if (counts[i] > 0)
                    res = i;
            }
            return res;
        } else {
            int a = nums[0];
            int b = nums[nums.length - 1];
            if (counts[a] > 1 && counts[b] > 1)
                return -1;
            if (counts[a] == 1 && counts[b] > 1)
                return a;
            if (counts[a] > 1 && counts[b] == 1)
                return b;
            if (a > b) {
                return a;
            } else {
                return b;
            }
        }
    }
}
