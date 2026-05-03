/*
 * Problem: 3028. Ant on the Boundary
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/ant-on-the-boundary/
 * Language: java
 * Date: 2026-05-03
 */

class Solution {
    public int returnToBoundaryCount(int[] nums) {
        int res = 0;
        int p = 0;
        for (int num : nums) {
            p += num;
            if (p == 0)
                res++;
        }
        return res;
    }
}
