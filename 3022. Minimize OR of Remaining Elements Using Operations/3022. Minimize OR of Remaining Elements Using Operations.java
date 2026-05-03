/*
 * Problem: 3022. Minimize OR of Remaining Elements Using Operations
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimize-or-of-remaining-elements-using-operations/
 * Language: java
 * Date: 2026-05-03
 */

class Solution {
    public int minOrAfterOperations(int[] nums, int k) {
        int res = 0;
        int mask = 0;
        for (int i = 29; i >= 0; i--) {
            mask += 1 << i;
            int target = res ^ mask;
            int count = 0;
            int and = 0;
            for (int num : nums) {
                if (and != 0) {
                    and &= num;
                    count++;
                } else {
                    and = target & num;
                }
            }
            if (and != 0)
                count++;
            if (count > k)
                res += 1 << i;
        }
        return res;
    }
}
