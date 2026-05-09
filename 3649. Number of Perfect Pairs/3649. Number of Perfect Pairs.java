/*
 * Problem: 3649. Number of Perfect Pairs
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/number-of-perfect-pairs/
 * Language: java
 * Date: 2026-05-09
 */

class Solution {
    public long perfectPairs(int[] nums) {
        int[] arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = Math.abs(nums[i]);
        }
        Arrays.sort(arr);
        int j = 0;
        long res = 0;
        for (int i = 0; i < arr.length; i++) {
            while (j < i && 2 * arr[j] < arr[i]) {
                j++;
            }
            res += i - j;
        }
        return res;
    }
}
