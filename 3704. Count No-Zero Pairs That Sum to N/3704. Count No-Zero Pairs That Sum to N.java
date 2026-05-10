/*
 * Problem: 3704. Count No-Zero Pairs That Sum to N
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/count-no-zero-pairs-that-sum-to-n/
 * Language: java
 * Date: 2026-05-10
 */

class Solution {
    public long countNoZeroPairs(long n) {
        String str = String.valueOf(n);
        int[] arr = new int[str.length()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = str.charAt(i) - '0';
        }
        return countPairs(arr);
    }

    public long countPairs(int[] arr) {
        long withCarry = 0; // number of ways with carry from previous digit
        long withoutCarry = 1; // number of ways without carry
        int validWithoutCarry = 2;
        boolean prevDigitOne = false;
        boolean zeroSeen = false;
        boolean invalidForCarry = false;

        for (int i = 0; i < arr.length; i++) {
            int digit = arr[i];
            long nextWithCarry = 0;
            long nextWithoutCarry = 0;

            if (digit == 0)
                validWithoutCarry = 0;
            if (digit != 0 && zeroSeen)
                invalidForCarry = true;

            int extraCarry = 2;
            if (invalidForCarry || (digit == 0 && prevDigitOne) || (i > 0 && digit == 1)) {
                extraCarry = 0;
            } else if (i == 0 && digit == 1) {
                extraCarry = 1;
            }

            nextWithCarry = getPairCount(digit + 9) * withCarry + getPairCount(digit - 1) * withoutCarry + extraCarry;
            nextWithoutCarry = getPairCount(digit + 10) * withCarry + getPairCount(digit) * withoutCarry
                    + validWithoutCarry;

            if (digit == 0)
                zeroSeen = true;
            withCarry = nextWithCarry;
            withoutCarry = nextWithoutCarry;

            if (i > 0 && digit == 1) {
                prevDigitOne = true;
            } else if (digit != 0) {
                prevDigitOne = false;
            }
        }

        return withoutCarry - validWithoutCarry;
    }

    public int getPairCount(int n) {
        if (n <= 0)
            return 0;
        if (n <= 10)
            return n - 1;
        return 19 - n;
    }
}
