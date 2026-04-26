/*
 * Problem: 2341. Maximum Number of Pairs in Array
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/maximum-number-of-pairs-in-array/
 * Language: java
 * Date: 2026-04-26
 */

class Solution {
    public int[] numberOfPairs(int[] nums) {
        int[] counts = new int[101];
        for (int num : nums) {
            counts[num]++;
        }
        int[] res = new int[2];
        for (int count : counts) {
            res[0] += count / 2;
            res[1] += count % 2;
        }
        return res;
    }
}
