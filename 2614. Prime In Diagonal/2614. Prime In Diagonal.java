/*
 * Problem: 2614. Prime In Diagonal
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/prime-in-diagonal/
 * Language: java
 * Date: 2026-04-29
 */

class Solution {
    public int diagonalPrime(int[][] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i][i] > res && chk(nums[i][i]))
                res = nums[i][i];
            if (nums[i][nums.length - 1 - i] > res && chk(nums[i][nums.length - 1 - i]))
                res = nums[i][nums.length - 1 - i];
        }
        return res;
    }

    public boolean chk(int num) {
        if (num == 1)
            return false;
        for (int i = 2; i <= (int) Math.sqrt(num); i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }
}
