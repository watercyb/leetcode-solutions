/*
 * Problem: 3199. Count Triplets with Even XOR Set Bits I
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/count-triplets-with-even-xor-set-bits-i/
 * Language: java
 * Date: 2026-05-04
 */

class Solution {
    public int tripletCount(int[] a, int[] b, int[] c) {
        int countA = Count(a);
        int countB = Count(b);
        int countC = Count(c);
        return (a.length - countA) * (b.length - countB) * (c.length - countC)
                + countA * countB * (c.length - countC)
                + (a.length - countA) * countB * countC
                + countA * (b.length - countB) * countC;
    }

    public int Count(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res += Integer.bitCount(num) % 2;
        }
        return res;
    }
}
