/*
 * Problem: 163. Missing Ranges
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/missing-ranges/?envType=weekly-question&envId=2026-04-15
 * Language: java
 * Date: 2026-04-15
 */

class Solution {
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) {
            res.add(Arrays.asList(new Integer[] { lower, upper }));
            return res;
        }
        if (nums[0] > lower)
            res.add(Arrays.asList(new Integer[] { lower, nums[0] - 1 }));
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] - nums[i] > 1)
                res.add(Arrays.asList(new Integer[] { nums[i] + 1, nums[i + 1] - 1 }));
        }
        if (nums[nums.length - 1] < upper)
            res.add(Arrays.asList(new Integer[] { nums[nums.length - 1] + 1, upper }));
        return res;
    }
}
