/*
 * Problem: 2964. Number of Divisible Triplet Sums
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/number-of-divisible-triplet-sums/
 * Language: java
 * Date: 2026-05-02
 */

class Solution {
    public int divisibleTripletCount(int[] nums, int d) {
        int n = nums.length;
        int[] map = new int[d];
        int res = 0;
        for (int i = 2; i < n; i++) {
            int prev = nums[i - 1] % d;
            for (int j = i - 2; j >= 0; j--) {
                int v = (nums[j] + prev) % d;
                map[v] = map[v] + 1;
            }
            int v = nums[i] % d;
            res += (v == 0) ? map[0] : map[d - v];
        }
        return res;
    }
}
