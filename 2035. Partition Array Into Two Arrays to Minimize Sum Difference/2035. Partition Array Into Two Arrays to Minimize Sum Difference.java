/*
 * Problem: 2035. Partition Array Into Two Arrays to Minimize Sum Difference
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/partition-array-into-two-arrays-to-minimize-sum-difference/
 * Language: java
 * Date: 2026-04-23
 */

class Solution {
    public int minimumDifference(int[] nums) {
        int target = 0;
        for (int i = 0; i < nums.length; i++) {
            target += nums[i];
            nums[i] *= 2;
        }
        int n = nums.length / 2;
        int[][] arr1 = new int[n + 1][];
        arr1[0] = new int[1];
        int[][] arr2 = new int[n + 1][];
        arr2[0] = new int[1];
        int size = 1;
        for (int i = 1; i <= n; i++) {
            size *= n - i + 1;
            size /= i;
            arr1[i] = new int[size];
            arr2[i] = new int[size];
        }
        dfs(arr1, new int[n + 1], Arrays.copyOfRange(nums, 0, n), -1, 0, 0);
        dfs(arr2, new int[n + 1], Arrays.copyOfRange(nums, n, nums.length), -1, 0, 0);
        for (int i = 1; i <= n; i++) {
            Arrays.sort(arr1[i]);
            Arrays.sort(arr2[i]);
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i <= n; i++) {
            int j = n - i;

            int k = 0;
            int l = arr2[j].length - 1;
            while (k < arr1[i].length && l >= 0) {
                int tmp = target - (arr1[i][k] + arr2[j][l]);
                res = Math.min(Math.abs(tmp), res);
                if (tmp > 0) {
                    k++;
                } else if (tmp < 0) {
                    l--;
                } else {
                    return 0;
                }
            }
        }
        return res;
    }

    public void dfs(int[][] arr, int[] idx, int[] nums, int i, int sum, int n) {
        if (i == nums.length || n == arr.length)
            return;
        arr[n][idx[n]] = sum;
        idx[n]++;
        for (int j = i + 1; j < nums.length; j++) {
            dfs(arr, idx, nums, j, sum + nums[j], n + 1);
        }
    }
}
