/*
 * Problem: 4060. Count Evenly Good Integers
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/count-evenly-good-integers/
 * Language: java
 * Date: 2026-09-22
 */

class Solution {
    public long countEvenlyGoodIntegers(long l, long r) {
        return count(r) - count(l - 1);
    }

    public long count(long n) {
        if (n == 0)
            return 0;
        List<Integer> list = new ArrayList<>();
        while (n > 0) {
            list.add((int) (n % 10));
            n /= 10;
        }
        int[] arr = new int[list.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(arr.length - 1 - i);
        }
        long[] DP = new long[arr.length + 1];
        int count = 0;
        boolean isFirst = true;
        for (int digit : arr) {
            DP[DP.length - 1] *= 5;
            for (int i = DP.length - 2; i >= 0; i--) {
                DP[i + 1] += DP[i] * 5;
                DP[i] *= 5;
            }
            if (isFirst) {
                isFirst = false;
                int even = (digit - 1) / 2;
                int odd = digit - even - 1;
                DP[count + 1] += even;
                DP[count] += odd;
            } else {
                int even = (digit + 1) / 2;
                int odd = digit - even;
                DP[count + 1] += even;
                DP[count] += odd;
                DP[0] += 5;
                DP[1] += 4;
            }
            count += (digit + 1) % 2;
        }
        long res = 0;
        if (count % 2 == 0)
            res++;
        for (int i = 0; i < DP.length; i += 2) {
            res += DP[i];
        }
        return res;
    }
}
