/*
 * Problem: 3915. Maximum Sum of Alternating Subsequence With Distance at Least K
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/maximum-sum-of-alternating-subsequence-with-distance-at-least-k/
 * Language: java
 * Date: 2026-04-29
 */

class Solution {
    public long maxAlternatingSum(int[] nums, int k) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        BIT bit = new BIT(max + 2);
        BITRev bitRev = new BITRev(max + 2);
        long res = 0;
        long[] DPInc = new long[nums.length];
        long[] DPDec = new long[nums.length];
        for (int i = 0; i < k; i++) {
            DPInc[i] = bit.get(nums[i] - 1) + nums[i];
            DPDec[i] = bitRev.get(nums[i] + 1) + nums[i];
            res = Math.max(res, Math.max(DPInc[i], DPDec[i]));
        }
        for (int i = k; i < nums.length; i++) {
            bitRev.inset(nums[i - k], DPInc[i - k]);
            bit.inset(nums[i - k], DPDec[i - k]);
            DPInc[i] = bit.get(nums[i] - 1) + nums[i];
            DPDec[i] = bitRev.get(nums[i] + 1) + nums[i];
            res = Math.max(res, Math.max(DPInc[i], DPDec[i]));
        }
        return res;
    }
}

class BIT {
    long[] BIT;

    public BIT(int n) {
        BIT = new long[n];
    }

    public void inset(int i, long num) {
        i++;
        while (i < BIT.length) {
            BIT[i] = Math.max(BIT[i], num);
            i += i & -i;
        }
    }

    public long get(int i) {
        i++;
        long res = 0;
        while (i > 0) {
            res = Math.max(res, BIT[i]);
            i -= i & -i;
        }
        return res;
    }
}

class BITRev {
    long[] BIT;

    public BITRev(int n) {
        BIT = new long[n];
    }

    public void inset(int i, long num) {
        i = BIT.length - 1 - i;
        while (i < BIT.length) {
            BIT[i] = Math.max(BIT[i], num);
            i += i & -i;
        }
    }

    public long get(int i) {
        i = BIT.length - 1 - i;
        long res = 0;
        while (i > 0) {
            res = Math.max(res, BIT[i]);
            i -= i & -i;
        }
        return res;
    }
}
