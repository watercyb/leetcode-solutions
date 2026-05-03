/*
 * Problem: 3012. Minimize Length of Array Using Operations
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimize-length-of-array-using-operations/
 * Language: java
 * Date: 2026-05-03
 */

class Solution {
    public int minimumArrayLength(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
        }
        for (int num : nums) {
            if (num % min != 0)
                return 1;
        }
        int res = 0;
        for (int num : nums) {
            if (num == min)
                res++;
        }
        return (res + 1) / 2;
    }
}
