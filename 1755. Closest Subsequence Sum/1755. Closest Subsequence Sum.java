/*
 * Problem: 1755. Closest Subsequence Sum
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/closest-subsequence-sum/
 * Language: java
 * Date: 2026-04-20
 */

class Solution {
    public int minAbsDifference(int[] nums, int goal) {
        int max = 0;
        int min = 0;
        for (int num : nums) {
            if (num > 0) {
                max += num;
            } else {
                min += num;
            }
        }
        if (goal >= max) {
            return goal - max;
        } else if (goal <= min) {
            return min - goal;
        }
        Arrays.sort(nums);
        int[] before = new int[1 << (nums.length / 2)];
        dfs(nums, before, 0, 0, 0, nums.length / 2 - 1);
        int[] after = new int[1 << (nums.length - nums.length / 2)];
        idx = 0;
        dfs(nums, after, nums.length / 2, 0, nums.length / 2, nums.length - 1);
        int j = after.length - 1;
        int res = Integer.MAX_VALUE;
        Arrays.sort(before);
        Arrays.sort(after);
        for (int i = 0; i < before.length; i++) {
            while (j >= 0 && before[i] + after[j] >= goal) {
                j--;
            }
            if (j < before.length - 1)
                res = Math.min(Math.abs(before[i] + after[j + 1] - goal), res);
            if (j >= 0) {
                res = Math.min(Math.abs(before[i] + after[j] - goal), res);
            } else {
                break;
            }
        }
        return res;
    }

    int idx = 0;

    public void dfs(int[] nums, int[] sums, int i, int sum, int l, int r) {
        if (i > r) {
            sums[idx++] = sum;
        } else {
            dfs(nums, sums, i + 1, sum, l, r);
            int j = i + 1;
            while (j < r && nums[i] == nums[j]) {
                j++;
            }
            int k = 1;
            while (i < j) {
                dfs(nums, sums, j, sum + k * nums[i], l, r);
                i++;
                k++;
            }
        }
    }
}
