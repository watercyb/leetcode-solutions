/*
 * Problem: 2916. Subarrays Distinct Element Sum of Squares II
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/subarrays-distinct-element-sum-of-squares-ii/?envType=daily-question&envId=2026-10-16
 * Language: java
 * Date: 2026-10-20
 */

class Solution {
    public int sumCounts(int[] nums) {
        int mod = 1_000_000_007;
        int max = 0;
        for (int num : nums) {
            max = Math.max(num, max);
        }
        BIT1 = new long[nums.length + 1];
        BIT2 = new long[nums.length + 1];
        int[] lasts = new int[max + 1];
        Arrays.fill(lasts, -1);
        long res = 0;
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            int j = lasts[nums[i]];
            sum += 2 * (get(i) - get(j)) + i - j;
            res = (res + sum) % mod;
            insert(j + 1, 1);
            insert(i + 1, -1);
            lasts[nums[i]] = i;
        }
        return (int) res;
    }

    long[] BIT1;
    long[] BIT2;

    public void insert(int i, int n) {
        i++;
        long left = (long) i * n;
        while (i < BIT1.length) {
            BIT1[i] += n;
            BIT2[i] += left;
            i += i & -i;
        }
    }

    public long get(int i) {
        i++;
        long res = 0;
        int right = i + 1;
        while (i > 0) {
            res += BIT1[i] * right - BIT2[i];
            i -= i & -i;
        }
        return res;
    }
}
