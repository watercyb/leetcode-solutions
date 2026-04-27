/*
 * Problem: 2440. Create Components With Same Value
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/create-components-with-same-value/
 * Language: java
 * Date: 2026-04-27
 */

class Solution {
    public int componentValue(int[] nums, int[][] edges) {
        List<Integer>[] lists = new ArrayList[nums.length];
        int sum = 0;
        int max = 0;
        for (int i = 0; i < lists.length; i++) {
            lists[i] = new ArrayList<>();
            sum += nums[i];
            max = Math.max(nums[i], max);
        }
        for (int[] edge : edges) {
            lists[edge[0]].add(edge[1]);
            lists[edge[1]].add(edge[0]);
        }
        int[][] links = new int[lists.length][];
        for (int i = 0; i < links.length; i++) {
            links[i] = new int[lists[i].size()];
            for (int j = 0; j < links[i].length; j++) {
                links[i][j] = lists[i].get(j);
            }
        }
        for (int i = max; i <= sum / 2; i++) {
            if (sum % i == 0 && dfs(links, nums, 0, -1, i) == 0)
                return sum / i - 1;
        }
        return 0;
    }

    public int dfs(int[][] links, int[] nums, int i, int prv, int target) {
        int res = nums[i];
        for (int next : links[i]) {
            if (next == prv)
                continue;
            int resNext = dfs(links, nums, next, i, target);
            if (resNext == -1)
                return -1;
            res += resNext;
        }
        if (res > target)
            return -1;
        if (res == target)
            return 0;
        return res;
    }
}
