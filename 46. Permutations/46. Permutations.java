/*
 * Problem: 46. Permutations
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/permutations/
 * Language: java
 * Date: 2026-03-25
 */

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        dfs(res, new ArrayList<>(), new boolean[nums.length], nums, 0);
        return res;
    }

    public void dfs(List<List<Integer>> res, List<Integer> Li, boolean[] used, int[] nums, int n) {
        if (n == nums.length) {
            List<Integer> tmp = new ArrayList<>();
            for (int in : Li) {
                tmp.add(in);
            }
            res.add(tmp);
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (used[i])
                    continue;
                Li.add(nums[i]);
                used[i] = true;
                dfs(res, Li, used, nums, n + 1);
                Li.remove(Li.size()-1);
                used[i] = false;
            }
        }
    }
}
