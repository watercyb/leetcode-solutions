/*
 * Problem: 3209. Number of Subarrays With AND Value of K
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/number-of-subarrays-with-and-value-of-k/
 * Language: java
 * Date: 2026-05-05
 */

class Solution {
    public long countSubarrays(int[] nums, int k) {
        int[] marks = new int[30];
        int target = 0;
        for (int i = 0; k > 0; i++) {
            int bit = k % 2;
            marks[i] = bit;
            target += bit;
            k /= 2;
        }
        int prv = 0;
        long res = 0;
        int[][] bits = new int[nums.length][30];
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            int num = nums[i];
            for (int j = 0; num > 0; j++) {
                int digit = num & 1;
                bits[i][j] = digit;
                count += digit & marks[j];
                num /= 2;
            }
            if (count < target) {
                res += getCount(marks, bits, target, prv, i - 1);
                prv = i + 1;
            }
        }
        res += getCount(marks, bits, target, prv, nums.length - 1);
        return res;
    }

    public long getCount(int[] marks, int[][] bits, int target, int l, int r) {
        if (l > r)
            return 0;
        int[] bitCounts = new int[30];
        long res = 0;
        int j = l - 1;
        int count = 0;
        for (int i = l; i <= r; i++) {
            while (j < i || (j < r && count > target)) {
                j++;
                count = 0;
                for (int k = 0; k < 30; k++) {
                    bitCounts[k] += bits[j][k];
                    if (bitCounts[k] == j - i + 1)
                        count++;
                }
            }
            if (count > target)
                break;
            res += r - j + 1;
            count = 0;
            for (int k = 0; k < 30; k++) {
                bitCounts[k] -= bits[i][k];
                if (bitCounts[k] == j - i)
                    count++;
            }
        }
        return res;
    }
}
