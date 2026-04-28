/*
 * Problem: 2592. Maximize Greatness of an Array
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximize-greatness-of-an-array/
 * Language: java
 * Date: 2026-04-28
 */

class Solution {
    public int maximizeGreatness(int[] nums) {
        Arrays.sort(nums);
        int j = nums.length - 1;
        int res = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[j] > nums[i]) {
                res++;
                j--;
            }
        }
        return res;
    }
}
