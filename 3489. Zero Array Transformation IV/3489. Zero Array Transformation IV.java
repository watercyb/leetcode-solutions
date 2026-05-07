/*
 * Problem: 3489. Zero Array Transformation IV
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/zero-array-transformation-iv/
 * Language: java
 * Date: 2026-05-07
 */

class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        if (chk(nums))
            return 0;
        int l = 0;
        int r = queries.length;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (chk(nums, queries, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        if (r == queries.length)
            return -1;
        return r + 1;
    }

    public boolean chk(int[] nums) {
        for (int num : nums) {
            if (num != 0)
                return false;
        }
        return true;
    }

    public boolean chk(int[] nums, int[][] queries, int mid) {
        int[][] arr = new int[nums.length + 1][11];
        for (int i = 0; i <= mid; i++) {
            arr[queries[i][0]][queries[i][2]]++;
            arr[queries[i][1] + 1][queries[i][2]]--;
        }
        int[] counts = new int[11];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < arr[i].length; j++) {
                sum += j * arr[i][j];
                counts[j] += arr[i][j];
            }
            if (sum < nums[i] || !dfs(counts, 1, nums[i])) {
                return false;
            }
        }
        return true;
    }

    public boolean dfs(int[] counts, int i, int target) {
        if (target == 0)
            return true;
        if (target < 0 || i == counts.length)
            return false;
        for (int j = counts[i]; j >= 0; j--) {
            if (dfs(counts, i + 1, target - j * i))
                return true;
        }
        return false;
    }
}
