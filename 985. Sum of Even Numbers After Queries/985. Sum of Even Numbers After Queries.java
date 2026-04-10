/*
 * Problem: 985. Sum of Even Numbers After Queries
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/sum-of-even-numbers-after-queries/
 * Language: java
 * Date: 2026-04-10
 */

class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int sum = 0;
        for (int num : nums) {
            if ((num & 1) == 0)
                sum += num;
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int a = nums[queries[i][1]];
            nums[queries[i][1]] += queries[i][0];
            int b = nums[queries[i][1]];
            if ((a & 1) == 0) {
                if ((b & 1) == 0) {
                    sum += queries[i][0];
                } else {
                    sum -= a;
                }
            } else if ((b & 1) == 0) {
                sum += b;
            }
            res[i] = sum;
        }
        return res;
    }
}
