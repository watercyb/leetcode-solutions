/*
 * Problem: 2731. Movement of Robots
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/movement-of-robots/
 * Language: java
 * Date: 2026-04-30
 */

class Solution {
    public int sumDistance(int[] nums, String s, int d) {
        int mod = 1_000_000_007;
        long[] arr = new long[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (s.charAt(i) == 'L') {
                arr[i] = (long) nums[i] - d;
            } else {
                arr[i] = (long) nums[i] + d;
            }
        }
        Arrays.sort(arr);
        long sum = 0;
        long res = 0;
        for (int i = 1; i < nums.length; i++) {
            sum = (sum + (arr[i] - arr[i - 1]) * i) % mod;
            res = res + sum;
        }
        return (int) (res % mod);
    }
}
