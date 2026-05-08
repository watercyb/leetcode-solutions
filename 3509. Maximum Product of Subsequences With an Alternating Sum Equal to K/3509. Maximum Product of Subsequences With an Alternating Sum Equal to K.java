/*
 * Problem: 3509. Maximum Product of Subsequences With an Alternating Sum Equal to K
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/maximum-product-of-subsequences-with-an-alternating-sum-equal-to-k/
 * Language: java
 * Date: 2026-05-08
 */

class Solution {
    public int maxProduct(int[] nums, int k, int limit) {
        int count = chk(nums, k, limit);
        if (count == -1)
            return -1;
        int res = getMaxWOZero(nums, k, limit);
        if (res >= 0)
            return res;
        if (dfsZero(nums, 0, 1, 0, k, false, count))
            return 0;
        return -1;
    }

    public boolean dfsZero(int[] nums, int i, int p, int sum, int k, boolean hasZero, int count) {
        if (sum == k && hasZero)
            return true;
        if ((count == 0 && !hasZero) || i == nums.length)
            return false;
        if (nums[i] == 0)
            count--;
        return dfsZero(nums, i + 1, -p, sum + p * nums[i], k, nums[i] == 0 || hasZero, count)
                || dfsZero(nums, i + 1, p, sum, k, hasZero, count);
    }

    public int getMaxWOZero(int[] nums, int k, int limit) {
        HashSet<Integer> HS = new HashSet<>();
        HS.add(h(1, 0, 0));
        int res = -1;
        for (int num : nums) {
            if (num == 0)
                continue;
            HashSet<Integer> HSNext = new HashSet<>();
            for (int h : HS) {
                int pro = h / 7201;
                h %= 7201;
                int sum = h / 2 - 1800;
                int p = h & 1;
                pro *= num;
                if (pro > limit)
                    continue;
                if (p == 0) {
                    sum += num;
                } else {
                    sum -= num;
                }
                if (sum == k)
                    res = Math.max(pro, res);
                HSNext.add(h(pro, sum, 1 - p));
            }
            HS.addAll(HSNext);
        }
        return res;
    }

    public int h(int pro, int sum, int p) {
        return pro * 7201 + (sum + 1800) * 2 + p;
    }

    public int chk(int[] nums, int k, int limit) {
        int pMax = nums[0];
        int nMax = Integer.MIN_VALUE / 2;
        int pMin = nums[0];
        int nMin = Integer.MAX_VALUE / 2;
        int count = 0;
        if (nums[0] == 0)
            count++;
        for (int i = 1; i < nums.length; i++) {
            int pMaxNext = Math.max(Math.max(nMax + nums[i], nums[i]), pMax);
            int nMaxNext = Math.max(pMax - nums[i], nMax);
            int pMinNext = Math.min(Math.min(nMin + nums[i], nums[i]), pMin);
            int nMinNext = Math.min(pMin - nums[i], nMin);
            pMax = pMaxNext;
            nMax = nMaxNext;
            pMin = pMinNext;
            nMin = nMinNext;
            if (nums[i] == 0)
                count++;
        }
        if (Math.max(pMax, nMax) < k || Math.min(pMin, nMin) > k)
            return -1;
        return count;
    }
}
