/*
 * Problem: 3684. Maximize Sum of At Most K Distinct Elements
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/maximize-sum-of-at-most-k-distinct-elements/
 * Language: java
 * Date: 2026-05-09
 */

class Solution {
    public int[] maxKDistinct(int[] nums, int k) {
        Arrays.sort(nums);
        int[] res = new int[k];
        int idx = 1;
        res[0] = nums[nums.length-1];
        for (int i = nums.length - 2; i >= 0 && idx < k; i--) {
            if (nums[i] != res[idx - 1])
                res[idx++] = nums[i];
        }
        return Arrays.copyOf(res, idx);
    }
}
