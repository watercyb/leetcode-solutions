/*
 * Problem: 2176. Count Equal and Divisible Pairs in an Array
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/count-equal-and-divisible-pairs-in-an-array/
 * Language: java
 * Date: 2026-04-24
 */

class Solution {
    public int countPairs(int[] nums, int k) {
        int res = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j] && i * j % k == 0)
                    res++;
            }
        }
        return res;
    }
}
