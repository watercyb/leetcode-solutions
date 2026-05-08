/*
 * Problem: 3524. Find X Value of Array I
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-x-value-of-array-i/
 * Language: java
 * Date: 2026-05-08
 */

class Solution {
    public long[] resultArray(int[] nums, int k) {
        if (k == 4)
            return resultArray(nums);
        long[] res = new long[k];
        int[] counts = new int[k];
        int count = 0;
        int mod = 1;
        for (int i = 0; i < nums.length; i++) {
            mod = mod * (nums[i] % k) % k;
            if (mod == 0) {
                res[0] += i + 1;
                count = 0;
                mod = 1;
                for (int j = 1; j < k; j++) {
                    counts[j] = 0;
                }
            } else {
                count++;
                for (int j = 1; j < k; j++) {
                    int diff = mod * rev(j, k) % k;
                    res[diff] += counts[j];
                }
                res[mod]++;
                counts[mod]++;
                res[0] += i + 1 - count;
            }
        }
        return res;
    }

    public int rev(int num, int mod) {
        if (num == 1)
            return num;
        return mod - mod / num * rev(mod % num, mod) % mod;
    }

    public long[] resultArray(int[] nums) {
        long[] res = new long[4];
        int c1 = 0;
        int c2 = 0;
        int c3 = 0;
        int mod = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 4 == 0) {
                res[0] += i + 1;
                c1 = 0;
                c2 = 0;
                c3 = 0;
                mod = 1;
            } else if (nums[i] % 4 == 2) {
                c2 = c1 + c3 + 1;
                c1 = 0;
                c3 = 0;
                res[2] += c2;
                res[0] += i + 1 - c2;
                mod = 1;
            } else {
                mod = mod * (nums[i] % 4) % 4;
                if (mod == 1) {
                    res[1] += c1 + 1;
                    res[3] += c3;
                    res[2] += c2;
                    res[0] += i - c1 - c2 - c3;
                    c1++;
                } else {
                    res[1] += c3;
                    res[3] += c1 + 1;
                    res[2] += c2;
                    res[0] += i - c1 - c2 - c3;
                    c3++;
                }
            }
        }
        return res;
    }
}
