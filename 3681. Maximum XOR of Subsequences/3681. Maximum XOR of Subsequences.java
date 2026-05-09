/*
 * Problem: 3681. Maximum XOR of Subsequences
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/maximum-xor-of-subsequences/
 * Language: java
 * Date: 2026-05-09
 */

class Solution {
    public int maxXorSubsequences(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int n = 32 - Integer.numberOfLeadingZeros(max);
        int[] arr = new int[n];
        int count = n;
        for (int num : nums) {
            for (int i = n - 1; i >= 0 && num > 0; i--) {
                if ((num & (1 << i)) == 0)
                    continue;
                if (arr[i] == 0) {
                    arr[i] = num;
                    count--;
                    break;
                } else {
                    num ^= arr[i];
                }
            }
            if (count == 0)
                break;
        }
        int res = 0;
        for (int i = n - 1; i >= 0; i--) {
            res = Math.max(res, res ^ arr[i]);
        }
        return res;
    }
}
