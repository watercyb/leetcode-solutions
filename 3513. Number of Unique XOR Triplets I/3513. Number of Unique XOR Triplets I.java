/*
 * Problem: 3513. Number of Unique XOR Triplets I
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/number-of-unique-xor-triplets-i/?envType=daily-question&envId=2026-07-23
 * Language: java
 * Date: 2026-07-23
 */

class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        if (n <= 2)
            return n;
        if ((n & -n) == n)
            return 2 * n;
        return (int) Math.pow(2, Math.ceil(Math.log(n) / Math.log(2)));
    }
}
