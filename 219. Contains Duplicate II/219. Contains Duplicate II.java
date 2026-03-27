/*
 * Problem: 219. Contains Duplicate II
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/contains-duplicate-ii/
 * Language: java
 * Date: 2026-03-27
 */

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> HS = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k)
                HS.remove(nums[i - k - 1]);
            if (!HS.add(nums[i]))
                return true;
        }
        return false;
    }
}
