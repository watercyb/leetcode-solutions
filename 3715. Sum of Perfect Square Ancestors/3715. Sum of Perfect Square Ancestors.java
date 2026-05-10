/*
 * Problem: 3715. Sum of Perfect Square Ancestors
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/sum-of-perfect-square-ancestors/
 * Language: java
 * Date: 2026-05-10
 */

class Solution {
    static int[] arr;

    public long sumOfAncestors(int n, int[][] edges, int[] nums) {
        if (arr == null) {
            arr = new int[100001];
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] != 0)
                    continue;
                for (int j = 1; i * j * j <= 100000; j++) {
                    arr[i * j * j] = i;
                }
            }
        }
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            nums[i] = arr[nums[i]];
            max = Math.max(max, nums[i]);
        }
        List<Integer>[] lists = new ArrayList[n];
        for (int i = 0; i < lists.length; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            lists[edge[0]].add(edge[1]);
            lists[edge[1]].add(edge[0]);
        }
        return dfs(lists, nums, new long[max + 1], 0, -1);
    }

    public long dfs(List<Integer>[] lists, int[] nums, long[] counts, int i, int prv) {
        long res = counts[nums[i]];
        counts[nums[i]]++;
        for (int next : lists[i]) {
            if (next == prv)
                continue;
            res += dfs(lists, nums, counts, next, i);
        }
        counts[nums[i]]--;
        return res;
    }
}
