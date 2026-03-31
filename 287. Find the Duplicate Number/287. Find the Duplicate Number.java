/*
 * Problem: 287. Find the Duplicate Number
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-the-duplicate-number/
 * Language: java
 * Date: 2026-03-31
 */

class Solution {
    public int findDuplicate(int[] nums) {
        int fast = nums[nums[0]];
        int slow = nums[0];
        while (fast != slow) {
            fast = nums[nums[fast]];
            slow = nums[slow];
        }
        fast = 0;
        while (fast != slow) {
            fast = nums[fast];
            slow = nums[slow];
        }
        return slow;
    }
}
