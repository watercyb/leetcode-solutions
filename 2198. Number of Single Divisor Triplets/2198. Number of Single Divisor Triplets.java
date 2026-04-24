/*
 * Problem: 2198. Number of Single Divisor Triplets
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/number-of-single-divisor-triplets/
 * Language: java
 * Date: 2026-04-24
 */

class Solution {
    public long singleDivisorTriplet(int[] nums) {
        int[] counts = new int[101];
        for (int num : nums) {
            counts[num]++;
        }
        long res = 0;
        for (int i = 1; i < 101; i++) {
            if (counts[i] == 0)
                continue;
            for (int j = i + 1; j < 101; j++) {
                if (counts[j] == 0)
                    continue;
                for (int k = j + 1; k < 101; k++) {
                    if (counts[k] == 0)
                        continue;
                    int sum = i + j + k;
                    int count = 0;
                    if (sum % i == 0)
                        count++;
                    if (sum % j == 0)
                        count++;
                    if (sum % k == 0)
                        count++;
                    if (count == 1)
                        res += (long) counts[i] * counts[j] * counts[k] * 6;
                }
            }
            for (int j = 1; j < 101; j++) {
                if (counts[j] < 1 || j == i)
                    continue;
                int sum = i + 2 * j;
                if (sum % i == 0 && sum % j != 0)
                    res += (long) counts[i] * counts[j] * (counts[j] - 1) * 3;
            }
        }
        return res;
    }
}
