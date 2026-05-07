/*
 * Problem: 3488. Closest Equal Element Queries
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/closest-equal-element-queries/
 * Language: java
 * Date: 2026-05-07
 */

class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            max = Math.max(num, max);
            min = Math.min(num, min);
        }
        int[] firsts = new int[max - min + 1];
        Arrays.fill(firsts, -1);
        int[] lasts = new int[max - min + 1];
        Arrays.fill(lasts, -1);
        int[] nexts = new int[nums.length];
        Arrays.fill(nexts, -1);
        int[] prvs = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i] - min;
            if (lasts[num] == -1) {
                prvs[i] = -1;
            } else {
                prvs[i] = lasts[num];
                nexts[lasts[num]] = i;
            }
            if (firsts[num] == -1)
                firsts[num] = i;
            lasts[num] = i;
        }
        List<Integer> res = new ArrayList<>();
        for (int query : queries) {
            if (prvs[query] == -1 && nexts[query] == -1) {
                res.add(-1);
            } else {
                int a = prvs[query] == -1 ? nums.length - lasts[nums[query] - min] + query : query - prvs[query];
                int b = nexts[query] == -1 ? nums.length - query + firsts[nums[query] - min] : nexts[query] - query;
                res.add(Math.min(a, b));
            }
        }
        return res;
    }
}
