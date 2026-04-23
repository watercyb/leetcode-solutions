/*
 * Problem: 2081. Sum of k-Mirror Numbers
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/sum-of-k-mirror-numbers/
 * Language: java
 * Date: 2026-04-23
 */

class Solution {
    public long kMirror(int k, int n) {
        int[] arr = new int[20];
        bases = new long[40];
        bases[0] = 1;
        for (int i = 1; i < bases.length; i++) {
            bases[i] = bases[i - 1] * k;
        }
        int len = 1;
        arr[0] = 1;
        long res = 0;
        while (true) {
            List<Long> list = new ArrayList<>();
            while (true) {
                long[] nums = chk(arr, len);
                if (nums[0] > 0) {
                    res += nums[0];
                    if (--n == 0)
                        return res;
                }
                if (nums[1] > 0)
                    list.add(nums[1]);
                if (next(arr, k) == len) {
                    len++;
                    for (long num1 : list) {
                        res += num1;
                        if (--n == 0)
                            return res;
                    }
                    break;
                }
            }
        }
    }

    long[] bases;

    public long[] chk(int[] arr, int len) {
        int l1 = len - 1;
        int l2 = len;
        int r1 = len - 1;
        int r2 = len - 1;
        long res1 = -bases[len - 1] * arr[0];
        long res2 = 0;
        for (int i = 0; i < len; i++) {
            res1 += (bases[l1++] + bases[r1--]) * arr[i];
            res2 += (bases[l2++] + bases[r2--]) * arr[i];
        }
        if (!isMir(res1))
            res1 = -1;
        if (!isMir(res2))
            res2 = -1;
        return new long[] { res1, res2 };
    }

    public boolean isMir(long num) {
        char[] chrs = String.valueOf(num).toCharArray();
        int i = 0;
        int j = chrs.length - 1;
        while (i < j) {
            if (chrs[i++] != chrs[j--])
                return false;
        }
        return true;
    }

    public int next(int[] arr, int k) {
        int carry = 1;
        int idx = -1;
        while (carry != 0) {
            idx++;
            int sum = arr[idx] + carry;
            carry = sum / k;
            arr[idx] = sum % k;
        }
        return idx;
    }
}
