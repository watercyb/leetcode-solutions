/*
 * Problem: 3514. Number of Unique XOR Triplets II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/number-of-unique-xor-triplets-ii/
 * Language: java
 * Date: 2026-05-08
 */

class Solution {
    public int uniqueXorTriplets(int[] nums) {
        boolean[] seens = new boolean[2048];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j >= 0; j--) {
                seens[nums[i] ^ nums[j]] = true;
            }
        }
        boolean[] seens1 = new boolean[2048];
        for (int num : nums) {
            for (int i = 0; i < seens.length; i++) {
                if (seens[i])
                    seens1[i ^ num] = true;
            }
        }
        int res = 0;
        for (boolean s : seens1) {
            if (s)
                res++;
        }
        return res;
    }
}
