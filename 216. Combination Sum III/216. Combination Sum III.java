/*
 * Problem: 216. Combination Sum III
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/combination-sum-iii/
 * Language: java
 * Date: 2026-03-27
 */

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        dfs(new ArrayList<>(), 1, k, n);
        return res;
    }

    List<List<Integer>> res = new ArrayList<>();

    public void dfs(List<Integer> list, int i, int k, int n) {
        if (n < 0)
            return;
        if (k == 0 && n == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        if (i == 10)
            return;
        dfs(list, i + 1, k, n);
        list.add(i);
        dfs(list, i + 1, k - 1, n - i);
        list.removeLast();
    }
}
