/*
 * Problem: 2183. Count Array Pairs Divisible by K
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/count-array-pairs-divisible-by-k/
 * Language: java
 * Date: 2026-04-24
 */

class Solution {
    public long countPairs(int[] nums, int k) {
        if (k == 1)
            return (long) nums.length * (nums.length - 1) / 2;
        int[] counts = new int[k + 1];
        int count = 0;
        for (int num : nums) {
            if (counts[GCD(num, k)]++ == 0)
                count++;
        }
        int[] arr = new int[count];
        int[] arr1 = new int[count];
        int idx = 0;
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > 0) {
                arr[idx] = i;
                arr1[idx++] = counts[i];
            }
        }
        long res = 0;
        for (int i = 0; i < arr.length; i++) {
            if ((long) arr[i] * arr[i] % k == 0)
                res += (long) arr1[i] * (arr1[i] - 1) / 2;
            for (int j = i + 1; j < arr.length; j++) {
                if ((long) arr[i] * arr[j] % k == 0)
                    res += (long) arr1[i] * arr1[j];
            }
        }
        return res;
    }

    public int GCD(int a, int b) {
        if (b == 0)
            return a;
        return GCD(b, a % b);
    }
}
