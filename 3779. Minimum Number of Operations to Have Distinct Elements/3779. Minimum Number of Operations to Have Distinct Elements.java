/*
 * Problem: 3779. Minimum Number of Operations to Have Distinct Elements
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-number-of-operations-to-have-distinct-elements/
 * Language: java
 * Date: 2026-05-10
 */

class Solution {
    public int minOperations(int[] nums) {
        HashSet<Integer> HS = new HashSet<>(nums.length, 0.99f);
        for (int i = nums.length - 1; i >= 0; i--) {
            if (!HS.add(nums[i]))
                return i / 3 + 1;
        }
        return 0;
    }
}
