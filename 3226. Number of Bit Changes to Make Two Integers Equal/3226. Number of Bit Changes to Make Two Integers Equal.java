/*
 * Problem: 3226. Number of Bit Changes to Make Two Integers Equal
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/number-of-bit-changes-to-make-two-integers-equal/
 * Language: java
 * Date: 2026-05-05
 */

class Solution {
    public int minChanges(int n, int k) {
        int num = n ^ k;
        if ((num & n) != num)
            return -1;
        return Integer.bitCount(num);
    }
}
