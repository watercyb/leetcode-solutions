/*
 * Problem: 3678. Smallest Absent Positive Greater Than Average
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/smallest-absent-positive-greater-than-average/
 * Language: java
 * Date: 2026-05-09
 */

class Solution {
    public int smallestAbsent(int[] nums) {
        boolean[] seens = new boolean[101];
        int sum = 0;
        for (int num : nums) {
            if (num >= 0)
                seens[num] = true;
            sum += num;
        }
        int idx = Math.max(sum / nums.length + 1, 1);
        while (idx < seens.length) {
            if (!seens[idx])
                return idx;
            idx++;
        }
        return 101;
    }
}
