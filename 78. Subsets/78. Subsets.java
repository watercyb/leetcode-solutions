/*
 * Problem: 78. Subsets
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/subsets/
 * Language: java
 * Date: 2026-03-25
 */

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), nums, 0);
        return res;
    }

    public void dfs(List<List<Integer>> res, List<Integer> Li, int[] nums, int i) {
        if (i == nums.length) {
            List<Integer> tmp = new ArrayList<>();
            for (int in : Li) {
                tmp.add(in);
            }
            res.add(tmp);
        } else {
            for (int j = i; j < nums.length; j++) {
                Li.add(nums[j]);
                dfs(res, Li, nums, j + 1);
                Li.remove(Li.size() - 1);
            }
            dfs(res, Li, nums, nums.length);
        }
    }
}
