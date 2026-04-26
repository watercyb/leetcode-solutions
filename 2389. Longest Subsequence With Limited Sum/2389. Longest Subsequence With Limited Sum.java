/*
 * Problem: 2389. Longest Subsequence With Limited Sum
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/longest-subsequence-with-limited-sum/
 * Language: java
 * Date: 2026-04-26
 */

class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int l = 0;
            int r = nums.length;
            while (l < r) {
                int mid = (l + r) >>> 1;
                if (nums[mid] > queries[i]) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            res[i] = l;
        }
        return res;
    }
}
