/*
 * Problem: 3316. Find Maximum Removals From Source String
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-maximum-removals-from-source-string/
 * Language: java
 * Date: 2026-05-06
 */

class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int[] res = new int[nums.size()];
        for (int i = 0; i < res.length; i++) {
            int num = nums.get(i);
            if (num == 2) {
                res[i] = -1;
            } else {
                res[i] = num - ((num + 1) & (-num - 1)) / 2;
            }
        }
        return res;
    }
}
