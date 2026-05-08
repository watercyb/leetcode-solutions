/*
 * Problem: 3542. Minimum Operations to Convert All Elements to Zero
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-operations-to-convert-all-elements-to-zero/
 * Language: java
 * Date: 2026-05-08
 */

class Solution {
    public int minOperations(int[] nums) {
        int[] MQ = new int[nums.length];
        int idx = 0;
        int res = 0;
        for (int num : nums) {
            if (num == 0) {
                res += idx;
                idx = 0;
            } else {
                while (idx > 0 && MQ[idx - 1] >= num) {
                    if (MQ[idx - 1] > num)
                        res++;
                    idx--;
                }
                MQ[idx++] = num;
            }
        }
        return res + idx;
    }
}
