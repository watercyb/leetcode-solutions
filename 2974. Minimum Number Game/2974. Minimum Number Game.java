/*
 * Problem: 2974. Minimum Number Game
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/minimum-number-game/
 * Language: java
 * Date: 2026-05-02
 */

class Solution {
    public int[] numberGame(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i += 2) {
            int temp = nums[i];
            nums[i] = nums[i - 1];
            nums[i - 1] = temp;
        }
        return nums;
    }
}
