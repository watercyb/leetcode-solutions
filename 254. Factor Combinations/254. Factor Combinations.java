/*
 * Problem: 254. Factor Combinations
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/factor-combinations/
 * Language: java
 * Date: 2026-03-31
 */

class Solution {
    public List<List<Integer>> getFactors(int n) {
        dfs(new ArrayList<>(), n, 2);
        return res;
    }

    List<List<Integer>> res = new ArrayList<>();

    public void dfs(List<Integer> list, int n, int l) {
        if (list.size() > 0) {
            list.add(n);
            res.add(new ArrayList<>(list));
            list.removeLast();
        }
        int r = (int) Math.sqrt(n);
        for (int i = l; i <= r; i++) {
            if (n % i == 0) {
                list.add(i);
                dfs(list, n / i, i);
                list.removeLast();
            }
        }
    }
}
