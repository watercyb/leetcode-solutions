/*
 * Problem: 3152. Special Array II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/special-array-ii/
 * Language: java
 * Date: 2026-05-04
 */

class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int mod = 0;
        int prv = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == mod) {
                prv = i;
                nums[i] = prv;
            } else {
                mod = 1 - mod;
                nums[i] = prv;
            }
        }
        boolean[] res = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            res[i] = nums[queries[i][1]] <= queries[i][0];
        }
        return res;
    }
}
