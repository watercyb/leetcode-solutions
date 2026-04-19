/*
 * Problem: 1681. Minimum Incompatibility
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimum-incompatibility/
 * Language: java
 * Date: 2026-04-19
 */

class Solution {
    public int minimumIncompatibility(int[] nums, int k) {
        if (k == 1) {
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            boolean[] seens = new boolean[nums.length + 1];
            for (int num : nums) {
                max = Math.max(max, num);
                min = Math.min(min, num);
                if (seens[num])
                    return -1;
                seens[num] = true;
            }
            return max - min;
        }
        if (k == nums.length)
            return 0;
        int[] counts = new int[nums.length + 1];
        int count = 0;
        for (int num : nums) {
            counts[num]++;
            if (counts[num] > k)
                return -1;
            if (counts[num] == 1)
                count++;
        }
        int[][] arr = new int[count][];
        int idx = 0;
        for (int i = counts.length - 1; i >= 1; i--) {
            if (counts[i] > 0)
                arr[idx++] = new int[] { i, counts[i] };
        }
        dfs(arr, new int[k][2], new int[k], 0, 0, 0, nums.length / k, 0);
        return res;
    }

    int res = Integer.MAX_VALUE;

    public void dfs(int[][] arr, int[][] slots, int[] sizes, int i, int j, int idx, int lim, int sum) {
        if (sum >= res)
            return;
        if (j == arr[i][1]) {
            i++;
            j = 0;
            idx = 0;
        }
        if (i == arr.length) {
            res = sum;
            return;
        }
        if (idx == slots.length)
            return;
        if (sizes[idx] != 0)
            dfs(arr, slots, sizes, i, j, idx + 1, lim, sum);
        if (sizes[idx] < lim) {
            int sumNext = sum;
            sizes[idx]++;
            if (sizes[idx] == 1) {
                slots[idx][0] = arr[i][0];
                dfs(arr, slots, sizes, i, j + 1, idx + 1, lim, sumNext);
            } else if (sizes[idx] == 2) {
                sumNext += slots[idx][0] - arr[i][0];
                slots[idx][1] = arr[i][0];
                dfs(arr, slots, sizes, i, j + 1, idx + 1, lim, sumNext);
                slots[idx][1] = 0;
            } else {
                int temp = slots[idx][1];
                sumNext += slots[idx][1] - arr[i][0];
                slots[idx][1] = arr[i][0];
                dfs(arr, slots, sizes, i, j + 1, idx + 1, lim, sumNext);
                slots[idx][1] = temp;
            }
            sizes[idx]--;
        }
    }
}
