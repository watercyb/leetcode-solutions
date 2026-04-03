/*
 * Problem: 368. Largest Divisible Subset
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/largest-divisible-subset/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int[] DP = new int[nums.length];
        int[] idx = new int[nums.length];
        int max = 0;
        int id = 0;
        for (int i = 0; i < nums.length; i++) {
            DP[i] = 1;
            idx[i] = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (DP[j] >= DP[i] && nums[i] % nums[j] == 0) {
                    DP[i] = DP[j] + 1;
                    idx[i] = j;
                    if (DP[i] > max) {
                        max = DP[i];
                        id = i;
                    }
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        while (id != -1) {
            res.addFirst(nums[id]);
            id = idx[id];
        }
        return res;
    }
}
