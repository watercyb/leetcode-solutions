/*
 * Problem: 442. Find All Duplicates in an Array
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-all-duplicates-in-an-array/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            nums[i]--;
        }
        for (int i = 0; i < nums.length; i++) {
            int idx = nums[i] % 100001;
            int count = nums[idx] / 100001;
            if (count < 3)
                nums[idx] += 100001;
            if (count == 1)
                res.add(idx + 1);
        }
        return res;
    }
}
