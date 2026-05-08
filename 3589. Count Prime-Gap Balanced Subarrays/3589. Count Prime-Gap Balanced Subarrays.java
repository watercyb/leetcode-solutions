/*
 * Problem: 3589. Count Prime-Gap Balanced Subarrays
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/count-prime-gap-balanced-subarrays/
 * Language: java
 * Date: 2026-05-08
 */

class Solution {
    static boolean[] nonPrime;

    public int primeSubarray(int[] nums, int k) {
        if (nonPrime == null) {
            nonPrime = new boolean[50001];
            nonPrime[0] = true;
            nonPrime[1] = true;
            for (int i = 2; i < nonPrime.length; i++) {
                if (nonPrime[i])
                    continue;
                for (int j = i * i; j > 0 && j < nonPrime.length; j += i) {
                    nonPrime[j] = true;
                }
            }
        }
        int[] MQ1 = new int[nums.length];
        int[] MQ2 = new int[nums.length];
        int[] arr = new int[nums.length];
        int l = 0;
        int r = 0;
        int MQ1L = 0;
        int MQ1R = 0;
        int MQ2L = 0;
        int MQ2R = 0;
        int res = 0;
        int idxL = 0;
        int idxR = 0;
        while (idxL < nums.length) {
            while (MQ1L < MQ1R && MQ1[MQ1L] < idxL) {
                MQ1L++;
            }
            while (MQ2L < MQ2R && MQ2[MQ2L] < idxL) {
                MQ2L++;
            }
            while (idxR < nums.length
                    && (nonPrime[nums[idxR]] || MQ1L == MQ1R
                            || (nums[idxR] - nums[MQ1[MQ1L]] <= k && nums[MQ2[MQ2L]] - nums[idxR] <= k))) {
                if (!nonPrime[nums[idxR]]) {
                    while (MQ1R > MQ1L && nums[MQ1[MQ1R - 1]] >= nums[idxR]) {
                        MQ1R--;
                    }
                    while (MQ2R > MQ2L && nums[MQ2[MQ2R - 1]] <= nums[idxR]) {
                        MQ2R--;
                    }
                    MQ1[MQ1R++] = idxR;
                    MQ2[MQ2R++] = idxR;
                    arr[r++] = idxR;
                }
                idxR++;
            }
            if (l == r)
                break;
            if (r - l >= 2)
                res += (idxR - arr[l + 1]) * (arr[l] - idxL + 1);
            idxL = arr[l] + 1;
            l++;
        }
        return res;
    }
}
