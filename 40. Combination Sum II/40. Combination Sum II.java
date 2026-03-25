/*
 * Problem: 40. Combination Sum II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/combination-sum-ii/
 * Language: java
 * Date: 2026-03-25
 */

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int count = 0;
        int[] counts = new int[51];
        for (int candidate : candidates) {
            if (candidate > target)
                continue;
            if (counts[candidate]++ == 0)
                count++;
        }
        int[][] arr = new int[count][2];
        int idx = 0;
        for (int i = counts.length-1; i >=0 ; i--) {
            if (counts[i] > 0)
                arr[idx++] = new int[] { i, counts[i] };
        }
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, arr, new ArrayList<>(), target, 0);
        return res;
    }

    public void dfs(List<List<Integer>> res, int[][] arr, List<Integer> list, int remain, int i) {
        if (remain == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        if (i == arr.length)
            return;
        int j = 0;
        while (j <= arr[i][1] && remain >= 0) {
            dfs(res, arr, list, remain, i + 1);
            remain -= arr[i][0];
            list.add(arr[i][0]);
            j++;
        }
        while (j > 0) {
            list.removeLast();
            j--;
        }
    }
}
