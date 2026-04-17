/*
 * Problem: 1403. Minimum Subsequence in Non-Increasing Order
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/minimum-subsequence-in-non-increasing-order/
 * Language: java
 * Date: 2026-04-17
 */

class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        int[] counts = new int[101];
        int target = 0;
        for (int num : nums) {
            counts[num]++;
            target += num;
        }
        target = target / 2;
        int sum = 0;
        List<Integer> res = new ArrayList<>();
        for (int i = 100; i >= 0; i--) {
            for (int j = 0; j < counts[i]; j++) {
                sum += i;
                res.add(i);
                if (sum > target)
                    return res;
            }
        }
        return res;
    }
}
