/*
 * Problem: 525. Contiguous Array
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/contiguous-array/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public int findMaxLength(int[] nums) {
        int[] arr = new int[2 * nums.length + 2];
        Arrays.fill(arr, -2);
        arr[nums.length] = -1;
        int res = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += 2 * nums[i] - 1;
            int tmp = sum + nums.length;
            if (arr[tmp] == -2) {
                arr[tmp] = i;
            } else {
                res = Math.max(i - arr[tmp], res);
            }
        }
        return res;
    }
}
