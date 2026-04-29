/*
 * Problem: 2681. Power of Heroes
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/power-of-heroes/
 * Language: java
 * Date: 2026-04-29
 */

class Solution {
    public int sumOfPower(int[] nums) {
        int mod = 1_000_000_007;
        Arrays.sort(nums);
        long sum = 0;
        long res = 0;
        for (int num : nums) {
            res = (res + (sum + num) * num % mod * num) % mod;
            sum = (sum * 2 + num) % mod;
        }
        return (int) res;
    }
}
