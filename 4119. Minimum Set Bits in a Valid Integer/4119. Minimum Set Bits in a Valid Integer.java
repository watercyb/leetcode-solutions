/*
 * Problem: 4119. Minimum Set Bits in a Valid Integer
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimum-set-bits-in-a-valid-integer/
 * Language: java
 * Date: 2026-11-22
 */

class Solution {
    public int minSetBits(int[] nums, int k) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        if (max == 0)
            return -1;
        int n = 32 - Integer.numberOfLeadingZeros(max);
        int[] counts = new int[n];
        boolean[] seens = new boolean[max + 1];
        for (int i = 0; i < k; i++) {
            update(counts, nums[i], 1);
        }
        int num = getNum(counts, k);
        if (num == 0)
            return -1;
        seens[num] = true;
        for (int i = k; i < nums.length; i++) {
            update(counts, nums[i - k], -1);
            update(counts, nums[i], 1);
            num = getNum(counts, k);
            if (num == 0)
                return -1;
            seens[num] = true;
        }
        boolean[] notGoods = new boolean[1 << n];
        int mask = (1 << n) - 1;
        for (int i = 0; i < seens.length; i++) {
            if (seens[i])
                dfs(notGoods, i ^ mask);
        }
        int res = 100;
        for (int i = 0; i < notGoods.length; i++) {
            if (!notGoods[i] && Integer.bitCount(i) < res)
                res = Integer.bitCount(i);
        }
        return res;
    }

    public void dfs(boolean[] notGoods, int n) {
        if (notGoods[n])
            return;
        notGoods[n] = true;
        for (int i = 1; i <= n; i <<= 1) {
            if ((n & i) != 0)
                dfs(notGoods, n - i);
        }
    }

    public void update(int[] counts, int num, int n) {
        int idx = 0;
        while (num > 0) {
            if ((num & 1) == 1)
                counts[idx] += n;
            num >>= 1;
            idx++;
        }
    }

    public int getNum(int[] counts, int k) {
        int res = 0;
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] == k)
                res += 1 << i;
        }
        return res;
    }
}
