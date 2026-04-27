/*
 * Problem: 2420. Find All Good Indices
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-all-good-indices/
 * Language: java
 * Date: 2026-04-27
 */

class Solution {
    public List<Integer> goodIndices(int[] nums, int k) {
        int[] rights = new int[nums.length];
        int count = 1;
        for (int i = nums.length - 2; i >= 1; i--) {
            rights[i] = count;
            if (nums[i] > nums[i + 1]) {
                count = 1;
            } else {
                count++;
            }
        }
        List<Integer> res = new ArrayList<>();
        count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (rights[i] >= k && count >= k)
                res.add(i);
            if (nums[i] > nums[i - 1]) {
                count = 1;
            } else {
                count++;
            }
        }
        return res;
    }
}
