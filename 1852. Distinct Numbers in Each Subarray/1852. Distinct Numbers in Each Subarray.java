/*
 * Problem: 1852. Distinct Numbers in Each Subarray
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/distinct-numbers-in-each-subarray/
 * Language: java
 * Date: 2026-04-21
 */

class Solution {
    public int[] distinctNumbers(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        int[] counts = new int[100001];
        int distinct = 0;
        for (int i = 0; i < k; i++) {
            if (counts[nums[i]]++ == 0)
                distinct++;
        }
        res[0] = distinct;
        for (int i = k; i < nums.length; i++) {
            if (counts[nums[i]]++ == 0)
                distinct++;
            if (counts[nums[i - k]]-- == 1)
                distinct--;
            res[i - k + 1] = distinct;
        }
        return res;
    }
}
