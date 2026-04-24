/*
 * Problem: 2177. Find Three Consecutive Integers That Sum to a Given Number
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-three-consecutive-integers-that-sum-to-a-given-number/
 * Language: java
 * Date: 2026-04-24
 */

class Solution {
    public long[] sumOfThree(long num) {
        if (num % 3 != 0)
            return new long[0];
        num /= 3;
        return new long[] { num - 1, num, num + 1 };
    }
}
