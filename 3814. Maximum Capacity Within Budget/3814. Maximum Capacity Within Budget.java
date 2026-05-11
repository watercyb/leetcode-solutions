/*
 * Problem: 3814. Maximum Capacity Within Budget
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-capacity-within-budget/
 * Language: java
 * Date: 2026-05-11
 */

class Solution {
    public int maxCapacity(int[] costs, int[] capacity, int budget) {
        int[][] arr = new int[costs.length + 1][];
        for (int i = 0; i < costs.length; i++) {
            arr[i] = new int[] { costs[i], capacity[i] };
        }
        arr[arr.length - 1] = new int[2];
        Arrays.sort(arr, (a, b) -> a[1] - b[1]);
        int idx = 0;
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][0] >= budget)
                continue;
            while (idx > 0 && arr[idx - 1][0] >= arr[i][0]) {
                if (arr[idx - 1][0] + arr[i][0] < budget && arr[idx - 1][1] + arr[i][1] > res)
                    res = arr[idx - 1][1] + arr[i][1];
                idx--;
            }
            arr[idx++] = arr[i];
        }
        int l = 0;
        int r = idx - 1;
        while (r > l) {
            while (l < r - 1 && arr[r][0] + arr[l + 1][0] < budget) {
                l++;
            }
            res = Math.max(res, arr[l][1] + arr[r][1]);
            r--;
        }
        return res;
    }
}
