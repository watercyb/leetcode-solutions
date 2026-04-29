/*
 * Problem: 2638. Count the Number of K-Free Subsets
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/count-the-number-of-k-free-subsets/
 * Language: java
 * Date: 2026-04-29
 */

class Solution {
    public long countTheNumOfKFreeSubsets(int[] nums, int k) {
        int[] seens = new int[1001 + k];
        long res = 1;
        for (int num : nums) {
            num += k;
            seens[num] = true;
        }
        long[][] mems = new long[nums.length + 1][2];
        for (int i = 0; i <= 1000; i++) {
            if (seens[i]) {
                int count = 1;
                int j = i + k;
                while (seens[j]) {
                    seens[j] = false;
                    j += k;
                    count++;
                }
                res *= cal(count);
            }
        }
        return res;
    }

    public long cal(int n) {
        long a = 0;
        long b = 1;
        for (int i = 0; i < n; i++) {
            long aNext = b;
            b += a;
            a = aNext;
        }
        return a + b;
    }
}
