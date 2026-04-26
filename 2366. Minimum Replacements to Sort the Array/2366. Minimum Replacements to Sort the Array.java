/*
 * Problem: 2366. Minimum Replacements to Sort the Array
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimum-replacements-to-sort-the-array/
 * Language: java
 * Date: 2026-04-26
 */

class Solution {
    public long minimumReplacement(int[] nums) {
        int last = nums[nums.length - 1];
        long res = 0;
        int i = nums.length - 2;
        while (i >= 0 && last > 1) {
            if (nums[i] > last) {
                int div = (nums[i] + last - 1) / last;
                res += div - 1;
                last = nums[i] / div;
            } else {
                last = nums[i];
            }
            i--;
        }
        while (i >= 0) {
            res += nums[i] - 1;
            i--;
        }
        return res;
    }
}
