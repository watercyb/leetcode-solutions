/*
 * Problem: 1. Two Sum
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/two-sum/
 * Language: java
 * Date: 2026-03-25
 */

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> HM = new HashMap<Integer, Integer>();
        for (int i=0; i<nums.length;i++) {
            if (HM.containsKey(nums[i])){
                return new int[] {HM.get(nums[i]),i};
            }
            HM.put(target-nums[i], i);
        }
        return new int[] {-1,-1};
    }
}
