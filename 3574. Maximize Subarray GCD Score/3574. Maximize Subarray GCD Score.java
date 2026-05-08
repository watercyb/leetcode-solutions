/*
 * Problem: 3574. Maximize Subarray GCD Score
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/maximize-subarray-gcd-score/
 * Language: java
 * Date: 2026-05-08
 */

class Solution {
    public long maxGCDScore(int[] nums, int k) {
        int[] counts = new int[nums.length];
        long res = 0;
        for (int i = 0; i < nums.length; i++) {
            res = Math.max(2 * nums[i], res);
            while ((nums[i] & 1) == 0) {
                counts[i]++;
                nums[i] >>= 1;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            int gcd = nums[i];
            int len = 1;
            int[] countsTemp = new int[33];
            for (int j = 1; j <= counts[i]; j++) {
                countsTemp[j]++;
            }
            for (int j = i + 1; j < nums.length; j++) {
                len++;
                for (int l = 1; l <= counts[j]; l++) {
                    countsTemp[l]++;
                }
                gcd = GCD(gcd, nums[j]);
                int idx = 1;
                while (idx < countsTemp.length && countsTemp[idx] == len) {
                    idx++;
                }
                if (len - countsTemp[idx] <= k)
                    idx++;
                long a = (long) Math.pow(2, idx - 1) * gcd;
                long b = a * len;
                if (b > res)
                    res = b;
                if (a * (nums.length - j - 1 + len) < res)
                    break;
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
