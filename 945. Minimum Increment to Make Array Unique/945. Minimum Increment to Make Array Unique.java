/*
 * Problem: 945. Minimum Increment to Make Array Unique
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-increment-to-make-array-unique/
 * Language: java
 * Date: 2026-04-10
 */

class Solution {
    public int minIncrementForUnique(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(num, max);
        }
        int[] counts = new int[nums.length + max + 1];
        for (int num : nums) {
            counts[num]++;
        }
        int res = 0;
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] == 0)
                continue;
            int tmp = counts[i] - 1;
            res += tmp;
            counts[i + 1] += tmp;
        }
        return res;
    }
}
