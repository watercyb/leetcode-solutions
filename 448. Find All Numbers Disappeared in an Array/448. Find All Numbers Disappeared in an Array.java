/*
 * Problem: 448. Find All Numbers Disappeared in an Array
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i + 1) {
                int j = nums[i] - 1;
                if (nums[j] == j + 1)
                    break;
                nums[i] = nums[j];
                nums[j] = j + 1;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1)
                res.add(i + 1);
        }
        return res;
    }
}
