/*
 * Problem: 3314. Construct the Minimum Bitwise Array I
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/construct-the-minimum-bitwise-array-i/
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
