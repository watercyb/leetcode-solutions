/*
 * Problem: 3906. Count Good Integers on a Grid Path
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/count-good-integers-on-a-grid-path/
 * Language: java
 * Date: 2026-04-20
 */

class Solution {
    public long countGoodIntegersOnPath(long l, long r, String directions) {
        int idx = 0;
        needs[idx] = true;
        for (char direction : directions.toCharArray()) {
            if (direction == 'D') {
                idx += 4;
            } else {
                idx++;
            }
            needs[idx] = true;
        }
        return getCount(r) - getCount(l - 1);
    }

    boolean[] needs = new boolean[16];

    public long getCount(long n) {
        int[] arr = new int[16];
        int idx = 15;
        while (n > 0) {
            arr[idx--] = (int) (n % 10);
            n /= 10;
        }
        long[] DP = new long[10];
        int prv = 0;
        long sum = 0;
        boolean isGood = true;
        for (int i = 0; i < arr.length; i++) {
            int digit = arr[i];
            if (needs[i]) {
                long sumNext = 0;
                for (int j = 9; j >= 0; j--) {
                    long temp = DP[j];
                    DP[j] = sum;
                    sumNext += DP[j];
                    sum -= temp;
                }
                if (isGood) {
                    for (int j = digit - 1; j >= prv; j--) {
                        DP[j]++;
                        sumNext++;
                    }
                    if (digit < prv) {
                        isGood = false;
                    } else {
                        prv = digit;
                    }
                }
                sum = sumNext;
            } else {
                for (int j = 0; j <= 9; j++) {
                    DP[j] *= 10;
                }
                sum *= 10;
                if (isGood) {
                    DP[prv] += digit;
                    sum += digit;
                }
            }
        }
        long res = sum;
        if (isGood)
            res++;
        return res;
    }
}
