/*
 * Problem: 90. Subsets II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/subsets-ii/
 * Language: java
 * Date: 2026-03-25
 */

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        int[] counts = new int[21];
        for (int num : nums) {
            counts[num + 10]++;
        }
        dfs(new ArrayList<>(), counts, 0);
        return res;
    }

    long[] base = new long[21];
    List<List<Integer>> res = new ArrayList<>();

    public void dfs(List<Integer> list, int[] counts, int i) {
        res.add(new ArrayList<>(list));
        for (int j = i; j < counts.length; j++) {
            for (int k = 0; k < counts[j]; k++) {
                list.add(j - 10);
                dfs(list, counts, j + 1);
            }
            for (int k = 0; k < counts[j]; k++) {
                list.removeLast();
            }
        }
    }
}
